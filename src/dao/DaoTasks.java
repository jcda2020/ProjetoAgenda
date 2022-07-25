package dao;

import java.util.Date;
import java.util.List;

import model.entities.Tasks;
import model.entities.Users;

public interface DaoTasks {

	
	void insertTasks(Tasks task);
	void updateTasks(Tasks task);
	void updateByDataTasks(Integer id);
	void deleteTask(Integer id);	
	Tasks findById(Integer id);
	List<Tasks> findAll();
	void doneTask(Integer id);
	List<Tasks> findByUsers(Users user);
	
}
