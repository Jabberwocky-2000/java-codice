package it.uniurb.pmo.pmo13.enums.en3;

import java.util.*;

public enum Zona {
	NORD, CENTRO, SUD;
	
	public List<Regione> getRegioni(){
		final ArrayList<Regione> list=new ArrayList<>();
		for (final Regione r: Regione.values()){
			if (r.getZona()==this){
				list.add(r);
			}
		}
		return list;
	}
}
