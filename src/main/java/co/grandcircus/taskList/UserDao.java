package co.grandcircus.taskList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class UserDao {

	/*
	 * Data Access Object is basically an object or an interface that provides access to an underlying database
	 */
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	*/
	@PersistenceContext
	EntityManager em;
	
	public List<User> findAll()
	{
		//String sql = "SELECT * FROM items";
		return em.createQuery("FROM User", User.class).getResultList();
	}
	
	public User findByEmail(String email)
	{
		//String sql = "SELECT * FROM items WHERE name = ?";
		return em.createQuery("FROM User WHERE email = :email", User.class).setParameter("email", email).getSingleResult();
				
	}
	
	public void create(User user)
	{
		em.persist(user); 

	}
	public void update(User user)
	{
		em.merge(user);
	}
	public void delete(Long id)
	{
		// Deleting with Hibernate entity manager requires fetching a reference first.
		User user = em.getReference(User.class, id);
		em.remove(user);
	}
	
}
