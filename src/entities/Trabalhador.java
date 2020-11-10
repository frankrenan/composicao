package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;

	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>(); // nunca pode ser instanciando no construtor

	public Trabalhador() {

	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContrato() {
		return contratos;
	}

	/* Método addContratc*/
	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}

	/* Método removeContract*/
	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	/* Método income */
	public double totalRenda(int ano, int mes) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();

		for (ContratoHora aux : contratos) {
			cal.setTime(aux.getData());
			int aux_ano = cal.get(Calendar.YEAR);
			int aux_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == aux_ano && mes == aux_mes) {
				sum += aux.valorTotal();
			}
		}
		return sum;
	}

}
