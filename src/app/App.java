package app;

import java.util.Scanner;

import dao.DaoFactory;
import dao.DaoTasks;
import model.entities.Tasks;
import model.entities.Users;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner leiaValores = new Scanner(System.in);
	
		
		char opcao = 'o';
		String nome;
		Integer id;
	
		//DepartamentoDAO departamentos = DaoFactory.createDepaartamentoDao() ;
		
		DaoTasks tasks = DaoFactory.createTasks();
		
		//VendedorDao vendedores = DaoFactory.createSellerDao();
		
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
			
			taskEntity.setTitulo("Java");
			taskEntity.setDescricao("Estudar DAO com jdbc");
			
			tasks.insertTasks(taskEntity);
			
				/*System.out.println("Digite o nome do novo departamento: ");
				nome = leiaValores.nextLine();
				departamentoEntity.setNome(nome);
				departamentos.insert(departamentoEntity);*/
				
			}
			
			if (opcao == '5') {
				tasks.doneTask(1);
				
			}
			

			
			
			
			
			
			System.out.println("Escolha uma opção abaixo: ");
			System.out.println( "0 - para encerrar o menu: \n" +
								"1 - para cadastrar uma tarefa: \n"+
								"2 - para pesquisar por uma tarefa: \n" +
								"3-  para carregar todos as tarefas: \n" +
								"4 - para atualziar uma tarefa: \n" + 
								"5 - para concluir uma tarefa:  \n" +
								"6 - para deletar uma tarefa:  ");
			
			opcao = leiaValores.next().charAt(0);	
		}
		
		
	}

}
