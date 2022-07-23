package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

public class DB {

	//Criação de um tipo Connection do java.sql
		private static Connection conn = null;
		//Criação do método que estabelece a conexão
		public static Connection getConnection() {
			// Se a conexão não existir criaremos uma
			if (conn == null) {
				
				//https://docs.oracle.com/javase/10/docs/api/java/util/Properties.html
				/*
				 * Declaração do objetos props a fim de 
				 * pegar um conjunto persistente de propriedades
				 * que no nosso caso será propriedades de um arquivo
				 * Assim, faremos isto por meio de um método criados 
				 * por nós mesmos. 
				 **/
				// o método loadProperties nos retornará um objeto Properties 
				//props capaz de ler um fluxo de dados que nosso caso será um arquivo
				Properties props = loadProperties();
				//Salvaremos uma cópia do valor pela chave(nome) denominada dburl do arquivo que criamos db.properties 
				String url = props.getProperty("dburl");
				try {
					//Atribuimos a conn (declarado mais acima) uma conexao com 
					//o MySQL e o banco de dados através da Classe DriverManager
					conn = DriverManager.getConnection(url, props);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//Tratamento da exceção
					throw new DbException(e.getMessage());
				}
				}
			//Retorno da conexão
			return conn;
		}
		/*
		 * o método loadProperties nos retornará um objeto Properties 
		props capaz de ler um fluxo de dados que nosso caso será um arquivo			
		 * 
		 */
		private static Properties loadProperties() {

			try {
				
				//https://docs.oracle.com/javase/10/docs/api/java/io/FileInputStream.html
				/*
				 * A classse FileInputStream nos permite ler um fluxo de dados 
				 * contidos num arquivo, no nosso caso o db.properties
				 */
				FileInputStream fs = new FileInputStream("db.properties");
				//Criação do objeto props a ser retornado pelo metódo
				Properties props = new Properties();
				//leitura das propriedades do arquivo requerido
				props.load(fs);
				return props;
				//Possíveis exceções de entrada e saída de dados (IO)
				//https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/io/IOException.html
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new DbException(e.getMessage());
			}
				
		}
		
		//Metódo para fechar a conexão
		public static void closeConnetion() {
			
				if (conn != null) {
					
					try {
						conn.close();
						
					}catch(SQLException e) {
						
						throw new DbException(e.getMessage());
					}
					
				}
			
		}
		
		//Metódo para fechar o ResultSet
		public static void closeResultset(ResultSet rs) {
			
				if (rs != null) {
					
					try {
						rs.close();
						
					}catch(SQLException e) {
						
						throw new DbException(e.getMessage());
					}
					
				}
			
		}
		
		// Método para fechar o Statement
		
		public static void closeStatement(Statement stmt ) {
			
			if (stmt != null) {
				
				try {
					stmt.close();
					
				}catch(SQLException e) {
					
					throw new DbException(e.getMessage());
				}
				
			}
		
	}
		
}
