package br.com.crud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Funcionario {
	List<String> nome = new ArrayList<>();

	public Funcionario(ArrayList<String> nome) {
		this.nome = nome;
	}

	public Funcionario() {
	}

	public List<String> getNome() {
		return Collections.unmodifiableList(nome);
	}

	public void adicionaFuncionario(String func) {
		if (func.equals("")) {
			System.out.println("Necessario informa um valor");
		} else {
			nome.add(func);
		}
	}

	public void listaFunc() {
		Iterator<String> it = nome.iterator();
		int index = 0;
		while (it.hasNext()) {
			System.out.println(index + " - " + it.next());
			index++;
		}

		System.out.println("");
	}

	public void deletarFunc(int index) {
		try {
			nome.remove(index);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro!!!\nfuncionario nao encontrado!!!\n\n");
		}
	}

	public void updateFuncionario(int indexDoFunc, String novoNome) {
		try {
			nome.set(indexDoFunc, novoNome);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro!!!\nfuncionario nao encontrado!!!\n\n");
		}
	}

	public void verificaSeExiste(String nomeFunc) {
		try {

			if (nome.contains(nomeFunc)) {
				System.out.println("Funcionario cadastrado!!");
			} else {
				System.out.println("Funcionario nao cadastrado no sistema!!\n");
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro!!!Redirecionando para a pagina de entrada\n\n");
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(nome, other.nome);
	}

}
