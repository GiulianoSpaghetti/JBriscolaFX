package org.altervista.numerone.javafx;

import java.util.Vector;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Carta {
	private IntegerProperty Seme=new SimpleIntegerProperty(this, "Seme", 0), Valore=new SimpleIntegerProperty(this, "Valore", 0), Punteggio=new SimpleIntegerProperty(this, "Punteggio", 0);
	private StringProperty SemeStr=new SimpleStringProperty(this, "SemeStr", "");
	private static CartaHelper helper;
	private static Vector<Carta> carte;
	private Carta(int n) {
		Seme.set(helper.GetSeme(n));
		Valore.set(helper.GetValore(n));
		Punteggio.set(helper.GetPunteggio(n));
		SemeStr.set(helper.GetSemeStr(Seme.get()));
	}
	
	public static void Inizializza(int n, CartaHelper h) {
		carte=new Vector<Carta>();
		helper=h;
		int i;
		for (i=0; i<n; i++) {
			carte.add(new Carta(i));
		}
	}
	
	public static CartaHelper GetIstanza() {return helper;}
	public static void dealloca() {
		carte.clear();
		helper=null;
	}
	public static Carta GetCarta(int quale) { 
		return carte.get(quale);
	}

	public int GetNumero() {
		return helper.GetNumero(Seme.get(), Valore.get());
	}
	public String GetValoreStr() {return ""+(Valore.get()+1);}
	public String GetSemeStr() { return SemeStr.get();}
	public int GetPunteggio() { return Punteggio.get();}
	public int GetSeme() {return Seme.get(); }
	public boolean StessoSeme(Carta c1) {return Seme.get()==c1.Seme.get();}
	public static CartaHelper.RISULTATI_COMPARAZIONE Compara(Carta c, Carta c1) {
		return Carta.helper.Compara(Carta.helper.GetNumero(c.Seme.get(), c.Valore.get()), Carta.helper.GetNumero(c1.Seme.get(), c1.Valore.get()));
	}
	
	static String GetSemeStr(int quale) {
		return carte.get(quale).GetSemeStr();
	}
	
	public String toString() {
		return GetValoreStr()+" "+GetSemeStr();
	}
}
