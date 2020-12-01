package br.edu.univas.main;

import br.edu.univas.main.cadastro;
import java.util.Scanner;

public class StartApp {

	public static cadastro[] contas = new cadastro[100];
	public static int i = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int escolha = 0;
		while (escolha != 3) {
			menu();
			escolha = scanner.nextInt();
			if (escolha == 1) {
				cadastrarConta();
				i++;
			} else if (escolha == 2) {
				verSaldo();
			} else if (escolha == 3) {
				break;
			} else {
				System.out.println("Opção inválida! Utilize uma das opções acima corretamente.");
			}
		}
		System.out.println("Obrigado por usar-me. Vejo você mais tarde !");
		scanner.close();
	}

	public static void menu() {
		System.out.println("=================================================" + "\n" + "\n" + "  Conta" + "\n" + "\n"
				+ "1. Cadastrar conta" + "\n" + "2. Ver saldo" + "\n" + "3. Sair" + "\n" + "\n"
				+ "=================================================");
	}

	public static void cadastrarConta() {
		Scanner scanner = new Scanner(System.in);
		cadastro usuario = new cadastro();

		System.out.println("=================================" + "\n" + "Digite abaixo a descrição da conta:");
		usuario.descricao = scanner.nextLine();
		// String descricaoConta = cadastro.descricao;

		System.out.println("Digite abaixo o valor:");
		usuario.valor = scanner.nextFloat();
		scanner.nextLine();

		System.out.println("Digite abaixo a data de vencimento:");
		usuario.dataVencimento = scanner.nextLine();
		// String vencimento = cadastro.dataVencimento;

		System.out.println("Digite abaixo o tipo da conta (Receita ou Despesa):");
		usuario.tipo = scanner.nextLine();
		contas[i] = usuario;

		System.out.println("=================================" + "\n" + "\n" + "Descrição: " + usuario.descricao + "\n"
				+ "Valor: R$" + usuario.valor + "\n" + "Vencimento: " + usuario.dataVencimento + "\n" + "Tipo: "
				+ usuario.tipo + "=================================");
		;

	}

	public static void verSaldo() {
		float despesa = 0f;
		float receita = 0f;

		for (int i = 0; i < 100; i++) {
			if (contas[i] != null && contas[i].tipo.equals("Despesa")) {
				despesa += contas[i].valor;
			} else if (contas[i] != null && contas[i].tipo.equals("Receita")) {
				receita += contas[i].valor;
			}
		}

		float total = receita - despesa;

		System.out.println("O saldo é igual a R$" + total);
	}

}
