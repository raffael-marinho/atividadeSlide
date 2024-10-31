package Questoes;

import java.util.Scanner;

public class Respostas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("=== Menu ===");
			System.out.println("1. Calcular IMC");
			System.out.println("2. Calcular Metabolismo Basal");
			System.out.println("3. Verificar se o Número é PAR ou ÍMPAR");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					calcularIMC(scanner);
					break;
				case 2:
					calcularMetabolismoBasal(scanner);
					break;
				case 3:
					verificarParImpar(scanner);
					break;
				case 4:
					System.out.println("Saindo do programa...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 4);

		scanner.close();
	}

	public static void calcularIMC(Scanner scanner) {
		System.out.print("Digite seu nome: ");
		String nome = scanner.next();

		System.out.print("Digite seu peso em kg: ");
		double peso = scanner.nextDouble();

		System.out.print("Digite sua altura em metros: ");
		double altura = scanner.nextDouble();

		double imc = peso / (altura * altura);

		String classificacao;
		if (imc < 19) {
			classificacao = "Abaixo do Peso";
		} else if (imc < 25) {
			classificacao = "Peso Normal";
		} else if (imc < 30) {
			classificacao = "Sobrepeso";
		} else if (imc < 40) {
			classificacao = "Obesidade do tipo I";
		} else {
			classificacao = "Obesidade Mórbida";
		}

		System.out.printf("%s, seu IMC é %.2f e sua classificação é: %s\n", nome, imc, classificacao);
	}

	public static void calcularMetabolismoBasal(Scanner scanner) {
		System.out.print("Digite seu gênero (M para masculino, F para feminino): ");
		char genero = scanner.next().charAt(0);

		System.out.print("Digite sua idade em anos: ");
		int idade = scanner.nextInt();

		System.out.print("Digite seu peso em kg: ");
		double peso = scanner.nextDouble();

		double metabolismoBasal = 0;

		if (genero == 'M' || genero == 'm') {
			if (idade >= 18 && idade <= 30) {
				metabolismoBasal = 15.057 * peso + 679;
			} else if (idade > 30 && idade <= 60) {
				metabolismoBasal = 11.6 * peso + 879;
			} else if (idade > 60) {
				metabolismoBasal = 13.5 * peso + 487;
			}
		} else if (genero == 'F' || genero == 'f') {
			if (idade >= 18 && idade <= 30) {
				metabolismoBasal = 14.7 * peso + 486.6;
			} else if (idade > 30 && idade <= 60) {
				metabolismoBasal = 8.7 * peso + 829;
			} else if (idade > 60) {
				metabolismoBasal = 10.5 * peso + 596;
			}
		} else {
			System.out.println("Gênero inválido. Use 'M' para masculino ou 'F' para feminino.");
			return;
		}

		System.out.printf("Seu metabolismo basal é %.2f Kcal\n", metabolismoBasal);
	}

	public static void verificarParImpar(Scanner scanner) {
		System.out.print("Digite um número: ");
		int numero = scanner.nextInt();

		if (numero % 2 == 0) {
			System.out.println("O número " + numero + " é PAR.");
		} else {
			System.out.println("O número " + numero + " é ÍMPAR.");
		}
	}
}
