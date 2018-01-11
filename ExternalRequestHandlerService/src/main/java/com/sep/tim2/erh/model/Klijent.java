package com.sep.tim2.erh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Klijent implements Serializable{
	
	private static final long serialVersionUID = 23507162692089508L;
	
	public Klijent() {}
	
	private Long id;
	@NotNull
	@Size(max = 30)
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
	private String ime;
	@NotNull
	@Size(max = 30)
	@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
	private String prezime;
	@NotNull
	@Pattern(regexp = "\\d+")
	@Size(min=13, max=13)
	private String jmbg;
	@NotNull
	private String brojPasosa;
	@NotNull
	@Size(max = 40)
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z ]+[\\d]+$")
	private String adresa;
	@NotNull
	@Size(max = 20)
	@Pattern(regexp = "\\d+")
	private String brojTelefona;
	@NotNull
	@Size(max = 50)
	@Pattern(regexp = "^[a-zA-Z\\d]+[@ ][a-z\\d]+\\.[a-z]+$")
	private String email;
	private List<Polisa> polise;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getBrojPasosa() {
		return brojPasosa;
	}
	public void setBrojPasosa(String brojPasosa) {
		this.brojPasosa = brojPasosa;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Polisa> getPolise() {
		if(polise == null) {
			return new ArrayList<Polisa>();
		}
		return polise;
	}
	public void setPolise(List<Polisa> polise) {
		this.polise = polise;
	}
}
