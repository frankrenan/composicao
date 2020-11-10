package entities;

import java.util.Date;

public class ContratoHora {

	private Date data;
	private Double valorPorHora;
	private Integer horas;

	public ContratoHora() {

	}

	public ContratoHora(Date date, Double valorPorHora, Integer horas) {
		this.data = date;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	/* Método totalValue*/
	public double valorTotal() {
		return valorPorHora * horas;
	}
}
