package com.airhacks.model;

public class Bus {

	private Location localizacao;
	private String motoristaAtual;
	private Integer qntPassageiros;

	public Bus(Location localizacao, String motoristaAtual, Integer qntPassageiros) {
		super();
		this.localizacao = localizacao;
		this.motoristaAtual = motoristaAtual;
		this.qntPassageiros = qntPassageiros;

	}

	public Location getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Location localizacao) {
		this.localizacao = localizacao;
	}

	public String getMotoristaAtual() {
		return motoristaAtual;
	}

	public void setMotoristaAtual(String motoristaAtual) {
		this.motoristaAtual = motoristaAtual;
	}

	public Integer getQntPassageiros() {
		return qntPassageiros;
	}

	public void setQntPassageiros(Integer qntPassageiros) {
		this.qntPassageiros = qntPassageiros;
	}

	@Override
	public String toString() {
		return "Bus [localizacao=" + localizacao + ", motoristaAtual=" + motoristaAtual + ", qntPassageiros="
				+ qntPassageiros + "]";
	}

}
