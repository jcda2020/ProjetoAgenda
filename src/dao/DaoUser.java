package dao;

import java.util.List;

import model.entities.Tasks;

public interface DaoUser {

	void insertTasks(Tasks task);
	void updateTasks(Tasks task);
	void deleteTask(Integer id);
	Tasks findById(Integer id);
	List<Tasks> findAll();
	
}
