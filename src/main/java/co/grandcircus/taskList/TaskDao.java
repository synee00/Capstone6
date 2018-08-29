package co.grandcircus.taskList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class TaskDao {

	/*
	 * Data Access Object is basically an object or an interface that provides access to an underlying database
	 */
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	*/
	@PersistenceContext
	EntityManager em;
	
	public List<Task> findAll()
	{
		//String sql = "SELECT * FROM items";
		return em.createQuery("FROM Task", Task.class).getResultList();
	}
	
	public List<Task> findByUser(User user)
	{
		//String sql = "SELECT * FROM items WHERE user_id = ?";
		return em.createQuery("FROM Task WHERE user_id = :u", Task.class).setParameter("u", user.getId()).getResultList();
	}
	
	public void create(Task task)
	{
		em.persist(task); 

	}
	public void update(Task task)
	{
		em.merge(task);
		
		/*String sql = "UPDATE Items SET name=\'" + item.getName() 
						+ "\', description=\'" + item.getDescription() 
						+ "\', quantity=" + item.getQuantity()
						+ ", price=" + item.getPrice()
						+ "  WHERE id=" + item.getId();
		em.createQuery(sql).executeUpdate();*/

	}
	public void delete(Long id)
	{
		// Deleting with Hibernate entity manager requires fetching a reference first.
		Task task = em.getReference(Task.class, id);
		em.remove(task);
	}
	
}
