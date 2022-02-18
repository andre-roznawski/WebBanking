package de.telekom.sea7.base;

public interface Zahlungen<T> {

	T[] getListe();

	void setListe(T element, int index);

	int size();

	T get(int i);

}