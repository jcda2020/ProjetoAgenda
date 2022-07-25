package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.jdbc.StatementImpl;

import dao.DaoFactory;
import dao.DaoTasks;
import db.DB;
import db.DbException;
import model.entities.Tasks;
import model.entities.Users;

public class DaoTasksImplements implements DaoTasks{

	private Connection conn;
	
	public DaoTasksImplements(Connection conn) {
	
		this.conn = conn;
	}
	
	public DaoTasksImplements() {
		
		
	}

	@Override
	public void insertTasks(Tasks tasks) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO tasks (titulo, descricao, users_id) VALUES "
				+ "(?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql, StatementImpl.RETURN_GENERATED_KEYS);
			stmt.setString(1,tasks.getTitulo() );
			stmt.setString(2,tasks.getDescricao() );
			
			stmt.setInt(3, tasks.getUser().getId());
			
			
			int linhaAfetada = stmt.executeUpdate();		
			
			if (linhaAfetada > 0 ) {
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Tarefa adicionada com sucesso!");					
				}
				
				
			}else {
				
				throw new DbException("Error: Nenhuma tarefa foi adicionada!");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(stmt);
		}
		
	}

	@Override
	public void updateTasks(Tasks task) {
		PreparedStatement stmt = null;
		String sql = "UPDATE tasks SET titulo = ?, descrica = ?, data = ?, users_id = ? WHERE id = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, task.getTitulo());
			stmt.setString(2, task.getDescricao());
			stmt.setDate(3, (java.sql.Date) task.getDataDaTarefa());
			stmt.setInt(4, task.getUser().getId());
			
			int linhaAfetada = stmt.executeUpdate();
			
			
			if(linhaAfetada > 0) {
				
				System.out.println("Alteração realizada com sucesso!");					
			}else {
				throw new DbException("Alteração não realizada!");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			DB.closeStatement(stmt);
		}
	}

	@Override
	public void deleteTask(Integer id) {

    PreparedStatement stmt = null;
    String sql = "DELETE FROM tasks WHERE id = ?";
    
    try {
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		//Verificar se houve linha afetada, pois pode acontecer de o id passado não existir no banco
		int linhaAfetada = stmt.executeUpdate();
		
		if (linhaAfetada == 0) {
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				int ID = rs.getInt("id");
				
				if (id == ID) {
					System.out.println("ID existente na base de dados!");
					break;
				}else {
					throw new DbException("ID não existente na base de dados!");
				}
			}
			
			
			throw new DbException("Tarefa não excluída!");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally {
		DB.closeStatement(stmt);
	}
		
	}

	@Override
	public Tasks findById(Integer id) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM tasks WHERE id = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			Tasks task = new Tasks();
			while (rs.next()) {			
				task.setId(rs.getInt("id"));
				task.setTitulo(rs.getString("titulo"));
				task.setDescricao(rs.getString("descricao"));
				task.setDataDaTarefa(rs.getDate("data"));
				task.setDoneTask(rs.getBoolean("done"));			
			}
			
			return task;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.closeStatement(stmt);
			DB.closeResultset(rs);
		}
		
		
		return null;
	}

	@SuppressWarnings("null")
	@Override
	public List<Tasks> findAll() {
		List<Tasks> tarefas = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tasks";	
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			Tasks task = new Tasks();
			
			while (rs.next()) {
				task.setId(rs.getInt("id"));
				task.setDataDaTarefa(rs.getDate("data"));
				task.setTitulo(rs.getString("titulo"));
				task.setDescricao(rs.getString("descricao"));
				task.setDoneTask(rs.getBoolean("done"));
				tarefas.add(task);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(stmt);
			DB.closeResultset(rs);
		}
		
		
		return tarefas;
	}

	@Override
	public void doneTask(Integer id) {
	Tasks task = new Tasks();		
		
	task.setDoneTask(true);
	
	
	String sql = "UPDATE tasks SET  done = ? WHERE id = ?";
	PreparedStatement stmt = null;
	try {
		stmt = conn.prepareStatement(sql);
		stmt.setBoolean(1, task.getDoneTask());
		stmt.setInt(2, id);
		
		int linhasAfetadas =  stmt.executeUpdate();
		
			if (linhasAfetadas > 0) {
				System.out.println("Tarefa concluída!");
				
			}else {
				
				throw new DbException("Modificação sem sucesso!");
			}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DB.closeStatement(stmt);
		
	}	
	
	}

	@Override
	public void updateByDataTasks(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tasks> findByUsers(Users user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
