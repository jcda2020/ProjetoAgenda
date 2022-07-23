package dao;

import db.DB;
import model.dao.DaoTasksImplements;
import model.dao.DaoUserImplements;

public class DaoFactory {

	public static DaoUser createUsers() {
		
		return new DaoUserImplements(DB.getConnection());
	}
	
public static DaoTasks createTasks() {
		
		return new DaoTasksImplements(DB.getConnection());
	}
	
	
}
