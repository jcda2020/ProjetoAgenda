package dao;

import java.util.List;

import model.entities.Tasks;
import model.entities.Users;

public interface DaoUser {
	
	void insertUsers(Users user);
	void updateUser(Users user);
	void deleteUser(Integer id);
	Users findById(Integer id);
	boolean authUser(String userName, String passwordUser);
	List<Users> findAll();
	Users findUser_id(String userName);
	
}
