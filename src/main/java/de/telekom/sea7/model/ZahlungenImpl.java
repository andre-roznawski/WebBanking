package de.telekom.sea7.model;

import de.telekom.sea7.base.Zahlung;
import de.telekom.sea7.base.Zahlungen;

public class ZahlungenImpl <T> implements Zahlungen <T> {
	
		private T[] liste = ((T[])new Object[999]);
		//private String message;

		//Konstruktor vorbelegung aller Felder mit aufsteigender integer Zahl beginnend bei null 
		public ZahlungenImpl() {
			//for (int i = 0; i < liste.length; i++) {
			//liste[i] = null;  }
		}

		@Override
		public T[] getListe() {
			return liste;
		}
		
		@Override
		public void setListe(T element, int index){
			//checkIndex (index);
			//if (!checkIndex (index)) {
				//throw new RuntimeException (index + " liegt ausserhalb des definierten Wertebereichs 0 - " + (size()-1));
				//System.out.println("Ungültige Eingabe von " + index);
				//return 0;
			//} else {
				this.liste[index] = element;
			//}		
		}
		
		@Override
		public int size() {
			int counter = 0;
			for (int i = 0; i < liste.length; i++) {
				var element = liste[i];
				if (element != null)
					counter++;
			}
			return counter;
		}

		@Override
		public T get(int i) {
		    return liste[i];	
			//return getListe()[i];
		}
		
		
//		 @Override
//		public boolean checkIndex (int index){
//		    	if ((index >= 0) && (index < liste.length)){
//		    		return true;
//		    	}else {
//		    		throw new RuntimeException (index + " liegt ausserhalb des definierten Wertebereichs 0 - " + (size()-1));
//		    	}
//		    	//im 1. Versuch war eine RuntimeException drin
//		    	//return (index >= 0) && (index < size());
//		    	
//		    }
}
