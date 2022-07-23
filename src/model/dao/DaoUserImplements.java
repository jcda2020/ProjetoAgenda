package model.dao;

import java.sql.Connection;
import java.util.List;

import dao.DaoUser;
import model.entities.Tasks;

public class DaoUserImplements implements DaoUser{

	private Connection conn;

	public DaoUserImplements(Connection conn) {
		
		this.conn = conn;
	}

	@Override
	public void insertTasks(Tasks task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTasks(Tasks task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tasks findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tasks> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
