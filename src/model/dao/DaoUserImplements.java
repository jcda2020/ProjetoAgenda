package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.DaoUser;
import db.DB;
import model.entities.Tasks;
import model.entities.Users;

public class DaoUserImplements implements DaoUser{

	private Connection conn;

	public DaoUserImplements(Connection conn) {
		
		this.conn = conn;
	}

	
	
	@Override
	public Users findUser_id(String userName) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer id = null;
		 Users user = new Users();
		String sql = "Select  id, nome,  userName From users Where userName = ? ";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
		
			
			while (rs.next()) {
				
				if (userName.equals(rs.getString("userName"))) {
					
					user.setId(rs.getInt("id"));
					user.setNome(rs.getString("nome"));	
					
					break;
					
				}	
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(stmt);
			DB.closeResultset(rs);
		}
		
		
		return user;		
	}
	

	@Override
	public boolean authUser(String userName, String passwordUser) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "Select  nome, userName, password From users Where userName = ? ";
		
		boolean confirm = false;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				String nameUser = rs.getString("userName");	
				String password = rs.getString("password");
				String name = rs.getString("nome");
				if (userName.equals(nameUser) && passwordUser.equals(password)) {
					confirm = true;
					System.out.println("Seja Bem vindo(a), " + name);
					
					break;					
				} 
			}			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			DB.closeStatement(stmt);
			DB.closeResultset(rs);
		}
		
		return confirm;
	}



	@Override
	public void insertUsers(Users user) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Users findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
