package com.sep.tim2.erh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KontekstAtributa implements Serializable{

	private static final long serialVersionUID = 2169394029110006240L;
	private Long id;
	private String naziv;
	private List<TipAtributa> tipoviAtributa;
	
	public KontekstAtributa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<TipAtributa> getTipoviAtributa() {
		if(tipoviAtributa == null) {
			tipoviAtributa = new ArrayList<>();
		}
		return tipoviAtributa;
	}

	public void setTipoviAtributa(List<TipAtributa> tipoviAtributa) {
		this.tipoviAtributa = tipoviAtributa;
	}
	
}
