package de.telekom.sea7.base;

public interface Kunde {

	String getName();

	void setName(String name);

	String getVorname();

	void setVorname(String vorname);

	String getStrasse_nr();

	void setStrasse_nr(String strasse_nr);

	int getPlz();

	void setPlz(int plz);

	String getWohnort();

	void setWohnort(String wohnort);
	
	void setKunde(String name, String vorname, String strasse_nr,
			int plz, String wohnort);

}