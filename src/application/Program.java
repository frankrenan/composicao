package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do Departamento: ");
		String departamento = sc.nextLine();

		System.out.println("Preencha os dados trabalhados: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nível: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salário Base: ");
		double salarioBase = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador),
				salarioBase, new Departamento(departamento));

		System.out.print("Quantos contratos tem o trabalhador: ");
		int n = sc.nextInt();

		/* ler os dados do contratos */
		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com contrato #" + i + " dados: ");
			System.out.print("Data (DD/MM/AAAA): ");
			Date contratoData = sdf.parse(sc.next());

			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();

			System.out.print("Duração (Horas): ");
			int horas = sc.nextInt();

			ContratoHora contrato = new ContratoHora(contratoData, valorPorHora, horas); // instanciando objeto contrato
			trabalhador.addContrato(contrato); // salvando contrato na lista
		}

		System.out.println("");
		System.out.print("Entre com mẽs e ano para calcular a renda total (MM/YYYY): ");
		String mesComAno = sc.next();
		int mes = Integer.parseInt(mesComAno.substring(0, 2));
		int ano = Integer.parseInt(mesComAno.substring(3));

		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out
				.println("Renda Total: " + mesComAno + ": " + String.format("%.2f", trabalhador.totalRenda(ano, mes)));

		sc.close();
	}
}
