package com.sep.tim2.erh.service;

import java.util.Date;

import com.sep.tim2.erh.model.OsiguranjeUplate;

public interface OsiguranjeService {
	public OsiguranjeUplate prepareOsiguranje(double iznos,Date datumSklapanja,Long osiguranjeId);
}
