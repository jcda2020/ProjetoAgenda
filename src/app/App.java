package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.DaoFactory;
import dao.DaoTasks;
import dao.DaoUser;
import model.entities.Tasks;
import model.entities.Users;



public class App {	
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		
		
		Scanner leiaValores = new Scanner(System.in);
		char opcao = 'o';
		String nome;
		String descricao;
		Integer id;
		boolean confirmUser = false;
	
		//Declaração de um dao atual, neste momento   
		DaoUser currentUser = null;	
		 Users user = new Users();
		
		//Enquanto o usuário e senha não forem encontrados solicita os dados de entrada
		while (confirmUser == false) {	
		//instanciação do dao que tem acesso aos métodos das regras de negócio
		currentUser = DaoFactory.createUsers();
		
		System.out.println("****************LOGIN***************");
		   System.out.println("Digite seu Username: ");
		 String  userName = leiaValores.next();
		   System.out.println("Digite sua Senha: ");
		   String password = leiaValores.next();
		   System.out.println("************************************");
		 //Verificando se o usuário e senha conferem com os da baase de dados 
		   confirmUser =  currentUser.authUser(userName, password);		   
		   
		   if (confirmUser) {
			   
			 user =  currentUser.findUser_id(userName);
			
			 //id = user.getId();
		   }
		   
		   	if(confirmUser == false) {
		   		System.out.println("usuário não cadastrado!");
		   		
		   	}
		}
	
		
			
		
		//Processo de autenticação para pode abrir o menu de opções			
		
			if (confirmUser) {
				//System.out.println("OK!");
				DaoTasks tasks = DaoFactory.createTasks();
				
				System.out.println("************************************");
				System.out.println("************************************");
				System.out.println("************************************");
				System.out.println("************************************");
				System.out.println("Escolha uma opção abaixo: ");
				System.out.println( "0 - para encerrar o menu: \n" +
						"1 - para cadastrar uma tarefa: \n"+
						"2 - para pesquisar por uma tarefa: \n" +
						"3-  para carregar todos as tarefas: \n" +
						"4 - para atualziar uma tarefa: \n" + 
						"5 - para concluir uma tarefa:  \n" +
						"6 - para deletar uma tarefa:  ");
				
				opcao = leiaValores.next().charAt(0);	
				
				leiaValores.nextLine();
				
				while (opcao != '0') {
					
					if (opcao == '1') {
						

						Tasks taskEntity = new Tasks();
					
					System.out.println("Título da tarefa: ");
					nome = leiaValores.nextLine();
				
					
					System.out.println("Digite a data desta tarefa: ");
					//Recebe a data como String
					String dataString = leiaValores.next();
						
					
					leiaValores.nextLine();  // Consume newline left-over
					
					
					System.out.println("Digite a descrição desta tarefa: ");
					descricao = leiaValores.nextLine();
					
					
					
					//Formata a data 
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					//Declara  um tipo java.util.Date
					Date dt = null;
					//Transforma uma String num tipo java.util.Date
					dt = formatter.parse(dataString);
					
				
					
					taskEntity.setTitulo(nome);
					taskEntity.setDescricao(descricao);
					taskEntity.setUser(user);
					taskEntity.setDataDaTarefa(dt);
					
					//O objeto da classe que implementa a interface aciona o insertTasks e enviar o objeto a ser inserido no banco de dados, que lá será um registro (uma linha na tabela) 
					tasks.insertTasks(taskEntity);			
						
					}
					
					if (opcao == '2') {
						
						System.out.println("Digite o id da tarefa: ");
						id = leiaValores.nextInt();
						
						Tasks taskEntity = new Tasks();
						
						 taskEntity = tasks.findById(id);
						System.out.println(taskEntity.toString());
					}
					
					if (opcao == '5') {
						System.out.println("Digite o id da tarefa a ser concluída: ");
						id = leiaValores.nextInt();
						tasks.doneTask(id);
						
					}
					

					
					
					
					System.out.println("************************************");
					System.out.println("************************************");
					System.out.println("Escolha uma opção abaixo: ");
					System.out.println( "0 - para encerrar o menu: \n" +
										"1 - para cadastrar uma tarefa: \n"+
										"2 - para pesquisar por uma tarefa: \n" +
										"3-  para carregar todos as tarefas: \n" +
										"4 - para atualziar uma tarefa: \n" + 
										"5 - para concluir uma tarefa:  \n" +
										"6 - para deletar uma tarefa:  ");
					
					opcao = leiaValores.next().charAt(0);	
					System.out.println("************************************");
					System.out.println("************************************");
					leiaValores.nextLine();
				}
				
			}
			
			
		
		
		
		
	}

}
