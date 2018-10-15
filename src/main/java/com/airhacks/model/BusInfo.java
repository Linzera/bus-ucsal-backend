package com.airhacks.model;

import com.airhacks.enums.RoteiroEnum;

public class BusInfo {

	private String horario;
	private RoteiroEnum roteiro;

	public BusInfo(String horario, RoteiroEnum roteiro) {
		super();
		this.horario = horario;
		this.roteiro = roteiro;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public RoteiroEnum getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(RoteiroEnum roteiro) {
		this.roteiro = roteiro;
	}

	@Override
	public String toString() {
		return "Horario: " + this.getHorario() + " Roteiro: " + this.getRoteiro().toString();
	}

}
