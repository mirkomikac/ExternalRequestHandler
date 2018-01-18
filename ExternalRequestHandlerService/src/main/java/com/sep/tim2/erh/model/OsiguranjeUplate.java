package com.sep.tim2.erh.model;

import java.util.Date;
import java.util.List;

public class OsiguranjeUplate {

	private Long id;
	private Date datumSklapanja;
	private double iznos;
	private List<Uplata> uplate;
	
	
	public OsiguranjeUplate(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatumSklapanja() {
		return datumSklapanja;
	}
	public void setDatumSklapanja(Date datumSklapanja) {
		this.datumSklapanja = datumSklapanja;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public List<Uplata> getUplate() {
		return uplate;
	}
	public void setUplate(List<Uplata> uplate) {
		this.uplate = uplate;
	}

}
