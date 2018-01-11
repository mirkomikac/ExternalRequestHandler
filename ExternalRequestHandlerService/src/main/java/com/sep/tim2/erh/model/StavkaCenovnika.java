package com.sep.tim2.erh.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StavkaCenovnika implements Serializable{

	private static final long serialVersionUID = 1530039357410789892L;
	private Long id;
	@NotNull
	@Min(0)
	private Double suma;
	private Cenovnik cenovnik;
	private PredefinisanaVrednost predefinisanaVrednost;
	
	public StavkaCenovnika() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public PredefinisanaVrednost getPredefinisanaVrednost() {
		return predefinisanaVrednost;
	}

	public void setPredefinisanaVrednost(PredefinisanaVrednost predefinisanaVrednost) {
		this.predefinisanaVrednost = predefinisanaVrednost;
	}
	
}
