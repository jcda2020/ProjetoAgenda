package app;

import java.util.Scanner;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner leiaValores = new Scanner(System.in);
	
		
		char opcao = 'o';
		String nome;
		Integer id;
	
		//DepartamentoDAO departamentos = DaoFactory.createDepaartamentoDao() ;
		
		
		//VendedorDao vendedores = DaoFactory.createSellerDao();
		
		System.out.println("Escolha uma opção abaixo: ");
		System.out.println( "0 - para encerrar o menu: \n" +
							"1 - para cadastrar um tarefas: \n"+
							"2 - para pesquisar por um tarefas: \n" +
							"3-  para carregar todos as tarefas: \n" +
							"4 - para atualziar uma tarefa: \n" + 
							"5 - para concluir uma tarefa:  \n" +
							"6 - para deletar uma tarefa:  ");
		
		opcao = leiaValores.next().charAt(0);	
		
		leiaValores.nextLine();
		while (opcao != '0') {
			
			if (opcao == '1') {
				
			/*Departamentos departamentoEntity = new Departamentos();
				System.out.println("Digite o nome do novo departamento: ");
				nome = leiaValores.nextLine();
				departamentoEntity.setNome(nome);
				departamentos.insert(departamentoEntity);
				*/
			}
			

			
			
			
			
			
			System.out.println("Escolha uma opção abaixo: ");
			System.out.println( "0 - para encerrar o menu: \n" +
								"1 - para cadastrar um tarefas: \n"+
								"2 - para pesquisar por um tarefas: \n" +
								"3-  para carregar todos as tarefas: \n" +
								"4 - para atualziar uma tarefa: \n" + 
								"5 - para concluir uma tarefa:  \n" +
								"6 - para deletar uma tarefa:  ");
			
			opcao = leiaValores.next().charAt(0);	
		}
		
		
	}

}
