package com.sep.tim2.erh.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class KontekstAtributa implements Serializable{

	private static final long serialVersionUID = 2169394029110006240L;
	private Long id;
	@NotNull
	@Size(max=50)
	private String naziv;
	private Boolean visestrukoDodavanje;
	private short redniBrojForme;
	private Boolean predstavljaGrupu;
	private List<TipAtributa> tipoviAtributa;
	private List<KontrolniAtribut> kontrolniAtributi;
	private List<TipOsiguranja> tipoviOsiguranja;
	
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

	public Boolean getVisestrukoDodavanje() {
		return visestrukoDodavanje;
	}

	public void setVisestrukoDodavanje(Boolean visestrukoDodavanje) {
		this.visestrukoDodavanje = visestrukoDodavanje;
	}

	public short getRedniBrojForme() {
		return redniBrojForme;
	}

	public void setRedniBrojForme(short redniBrojForme) {
		this.redniBrojForme = redniBrojForme;
	}

	public Boolean getPredstavljaGrupu() {
		return predstavljaGrupu;
	}

	public void setPredstavljaGrupu(Boolean predstavljaGrupu) {
		this.predstavljaGrupu = predstavljaGrupu;
	}

	public List<TipAtributa> getTipoviAtributa() {
		return tipoviAtributa;
	}

	public void setTipoviAtributa(List<TipAtributa> tipoviAtributa) {
		this.tipoviAtributa = tipoviAtributa;
	}

	public List<KontrolniAtribut> getKontrolniAtributi() {
		return kontrolniAtributi;
	}

	public void setKontrolniAtributi(List<KontrolniAtribut> kontrolniAtributi) {
		this.kontrolniAtributi = kontrolniAtributi;
	}

	public List<TipOsiguranja> getTipoviOsiguranja() {
		return tipoviOsiguranja;
	}

	public void setTipoviOsiguranja(List<TipOsiguranja> tipoviOsiguranja) {
		this.tipoviOsiguranja = tipoviOsiguranja;
	}
	
}
