package com.sep.tim2.erh.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sep.tim2.erh.model.OsiguranjeUplate;
import com.sep.tim2.erh.model.Uplata;
import com.sep.tim2.erh.service.OsiguranjeService;



@Service
public class OsiguranjeServiceImpl implements OsiguranjeService{

	@Override
	public OsiguranjeUplate prepareOsiguranje(double iznos, Date datumSklapanja, Long osiguranjeId) {
		OsiguranjeUplate o = new OsiguranjeUplate();
		o.setDatumSklapanja(datumSklapanja);
		o.setId(osiguranjeId);
		o.setIznos(iznos);
		o.setUplate(new ArrayList<Uplata>());
		return o;
	}



}
