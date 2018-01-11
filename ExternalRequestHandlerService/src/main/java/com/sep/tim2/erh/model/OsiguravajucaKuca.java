package com.sep.tim2.erh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OsiguravajucaKuca implements Serializable{
	
	private static final long serialVersionUID = -4134784298073252398L;

	private Long id;
	@NotNull
	@Size(min = 9, max = 9)
	@Pattern(regexp = "\\d+")
	private String pib;
	@NotNull
	@Size(max = 40)
	@Pattern(regexp = "^[a-zA-Z\\d ]+$")
	private String naziv;
	@NotNull
	@Size(max = 40)
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z ]+[\\d]+$")
	private String adresa;
	@NotNull
	@Size(max = 40)
	@Pattern(regexp = "^[A-Z][a-zA-Z\\d ]+$")
	private String mesto;
	@NotNull
	@Size(max = 20)
	@Pattern(regexp = "\\d+")
	private String telefon; 
	private List<TipOsiguranja> tipoviOsiguranja;
	private List<Cenovnik> listaCenovnika;
	
	public OsiguravajucaKuca() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPib() {
		return pib;
	}
	
	public void setPib(String pib) {
		this.pib = pib;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getMesto() {
		return mesto;
	}
	
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public List<TipOsiguranja> getTipoviOsiguranja() {
		if (tipoviOsiguranja == null) {
			return new ArrayList<TipOsiguranja>();
		}
		return tipoviOsiguranja;
	}
	
	public void setTipoviOsiguranja(List<TipOsiguranja> tipoviOsiguranja) {
		this.tipoviOsiguranja = tipoviOsiguranja;
	}

	public List<Cenovnik> getListaCenovnika() {
		if(tipoviOsiguranja == null) {
			return new ArrayList<>();
		}
		return listaCenovnika;
	}

	public void setListaCenovnika(List<Cenovnik> listaCenovnika) {
		this.listaCenovnika = listaCenovnika;
	}

}
