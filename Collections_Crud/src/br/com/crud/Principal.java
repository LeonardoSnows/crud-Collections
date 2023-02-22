package br.com.crud;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sca = new Scanner(System.in);
		Funcionario func = new Funcionario();
		int desicion = -1;

		while (desicion != 0) {
			System.out.println("Bem Vindo a Empresa XPTO, escolha uma das opcoes: ");
			System.out.println("--------------------------------------------------");
			System.out.println("1 - Para cadastrar os Funcionario");
			System.out.println("2 - Para Listar os Funcionarios");
			System.out.println("3 - Para Deletar um Funcionario");
			System.out.println("4 - Para atualizar o cadastro do Funcionario");
			System.out.println("5 - Para verificar se o funcionario existe");
			System.out.println("0 - Para Sair");
			System.out.print(">> ");
			casos(sca, func);
		}

	}

	private static void casos(Scanner sca, Funcionario func) throws IOException, InterruptedException {
		switch (sca.nextInt()) {
		case 1:
			adicionandoFuncionario(sca, func);
			break;
		case 2:
			listaFuncionario(func);
			break;
		case 3:
			deletarFunc(func, sca);
			break;
		case 4:
			updateFunc(func, sca);
			break;
		case 5:
			verifyFunc(func, sca);
			break;
		default:
			System.out.println("Informe um dos numeros que estao na tabela!!!\n");
			break;
		}
	}

	private static void verifyFunc(Funcionario func, Scanner sca) {
		System.out.println("Digite o nome do funcionario");
		System.out.print(">> ");
		func.verificaSeExiste(sca.next().trim());

	}

	private static void updateFunc(Funcionario func, Scanner sca) throws InterruptedException {
		listaFuncionario(func);
		System.out.println("Qual funcionario deseja atualizar?");
		System.out.print(">> ");
		int index = sca.nextInt();
		System.out.println("Informe o novo valor do [nome] do Funcionario");
		System.out.print(">> ");
		func.updateFuncionario(index, sca.next().trim());

	}

	private static void deletarFunc(Funcionario func, Scanner sca) throws InterruptedException {
		listaFuncionario(func);
		System.out.print("Qual funcionario deseja deletar: ");
		System.out.print(">> ");
		func.deletarFunc(sca.nextInt());
	}

	private static void listaFuncionario(Funcionario func) {
		System.out.println("Funcionarios:");
		func.listaFunc();
	}

	private static void adicionandoFuncionario(Scanner sca, Funcionario func) {
		int decision = 1;
		while (decision > 0) {
			System.out.println("Digite o nome do Funcinario que deseja adicionar: ");
			System.out.print(">> ");
			func.adicionaFuncionario(sca.next().trim());
			decision = repeteTexto(sca);
		}
	}

	private static int repeteTexto(Scanner sca) {
		int decision;
		do {
			System.out.println("Deseja adicionar mais um ?");
			System.out.println("1 - SIM\n0 - NAO");
			System.out.print(">> ");
			decision = sca.nextInt();
			if (decision > 1)
				System.out.println("informe ou 1 ou 0, outro numero nao sao permitidos");
		} while (decision > 1);

		return decision;
	}

}
