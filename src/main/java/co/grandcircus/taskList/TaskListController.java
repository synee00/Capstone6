package co.grandcircus.taskList;

import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class TaskListController {
	
	@Autowired
	TaskDao taskDao = new TaskDao();
	@Autowired
	UserDao userDao = new UserDao();
	
	
	
	@RequestMapping("/")
	public ModelAndView landingPage()
	{
		List<Task> task = taskDao.findAll();
		return new ModelAndView("landing");
		
	}
	
	@PostMapping("/register-submit")
	public ModelAndView submitEditProfile(User user, 
			HttpSession session, 
			RedirectAttributes redir,
			@RequestParam("email") String email, 
			@RequestParam("password") String password) {
		// Save the user information to the session.
		System.out.println(user);
		try {
			session.setAttribute("user", user);
			userDao.create(user);
		}
		catch(Exception e) {
			redir.addFlashAttribute("message", "User with email already exists!");
		}
		ModelAndView mav = new ModelAndView("redirect:/userTasks");
		return mav;
	}
	@PostMapping("/login-submit")
	// get the username and password from the form when it's submitted.
	public ModelAndView submitLoginForm(HttpSession session, 
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			RedirectAttributes redir) {
		try { 
			User user = userDao.findByEmail(email);
			if (user != null && password.equals(user.getPassword())) {
				//Match!
				session.setAttribute("user",  user);
				return new ModelAndView("redirect:/userTasks");
	
			}
			else if(user != null && !password.equals(user.getPassword()))
			{
				redir.addFlashAttribute("message", "User doesn't exist!");
			}
			else
			{
				//No match
				ModelAndView mav = new ModelAndView("redirect:/login");
				mav.addObject("message", "Wrong email or password.");
				return mav;
	
			}
		}
		catch(NoResultException e)
		{
			redir.addFlashAttribute("message", "No entity found for query!");
		}
		catch(Exception e)
		{
			redir.addFlashAttribute("message", "Error has occurred!");
		}
		
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		
		session.invalidate();
		redir.addFlashAttribute("meassage", "Logged out.");
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/userTasks")
	public ModelAndView userTasks(@SessionAttribute(name="user") User user)
	{		
		
		List<Task> task = taskDao.findByUser(user);
		//session.getAttribute(Long.parseUnsignedLong(user.getId());
		return new ModelAndView("userTasks", "task", task);
		
	}
	
	@RequestMapping("/add-submit")
	public ModelAndView submitAddForm(@SessionAttribute(name="user") User user, 
			@RequestParam("description") String description, 
			@RequestParam("dueDate") String dueDate,
			@RequestParam("startDate") String startDate,
			@RequestParam("complete") Boolean complete)
	{
		//adds new task to database
		Task task = new Task(null, user, description, dueDate, startDate, complete);
		taskDao.create(task);
		
		ModelAndView mav = new ModelAndView("redirect:/userTasks");

		return mav;
	}
	@RequestMapping("/edit-submit")
	public ModelAndView submitEditForm(Task task)
	{
		
		taskDao.update(task);
		
		ModelAndView mav = new ModelAndView("redirect:/userTasks");

		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Long id)
	{
		
		taskDao.delete(id);
		
		ModelAndView mav = new ModelAndView("redirect:/");

		return mav;
	}
	
}
