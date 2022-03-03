package de.telekom.sea7.model;

import de.telekom.sea7.base.Kunde;

public class KundeImpl implements Kunde {
	
	private String vorname;
	private String name;
	private String strasse_nr;
	private int plz;
	private String wohnort;
	
	public KundeImpl() {

	}

	public KundeImpl(String vorname, String name, String strasse_nr,
			int plz, String wohnort) {
		this.vorname = vorname;
		this.name = name;
		this.strasse_nr = strasse_nr;
		this.plz = plz;
		this.wohnort = wohnort;
	}

	public void setKunde(String vorname, String name, String strasse_nr,
			int plz, String wohnort) {
		this.vorname = vorname;
		this.name = name;
		this.strasse_nr = strasse_nr;
		this.plz = plz;
		this.wohnort = wohnort;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getVorname() {
		return vorname;
	}
	@Override
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	@Override
	public String getStrasse_nr() {
		return strasse_nr;
	}
	@Override
	public void setStrasse_nr(String strasse_nr) {
		this.strasse_nr = strasse_nr;
	}
	@Override
	public int getPlz() {
		return plz;
	}
	@Override
	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
}