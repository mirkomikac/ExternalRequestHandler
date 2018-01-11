package com.sep.tim2.erh.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VrednostAtributaOsiguranja implements Serializable{

	private static final long serialVersionUID = -7767383711555084420L;
	private Long id;
	@NotNull
	@Size(max = 50)
	private String vrednost;
	private Short grupacioniBroj;
	private TipAtributa tipAtributa;
	private Osiguranje osiguranje;
	
	public VrednostAtributaOsiguranja() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}

	public Short getGrupacioniBroj() {
		return grupacioniBroj;
	}

	public void setGrupacioniBroj(Short grupacioniBroj) {
		this.grupacioniBroj = grupacioniBroj;
	}

	public TipAtributa getTipAtributa() {
		return tipAtributa;
	}

	public void setTipAtributa(TipAtributa tipAtributa) {
		this.tipAtributa = tipAtributa;
	}

	public Osiguranje getOsiguranje() {
		return osiguranje;
	}

	public void setOsiguranje(Osiguranje osiguranje) {
		this.osiguranje = osiguranje;
	}
	
}
