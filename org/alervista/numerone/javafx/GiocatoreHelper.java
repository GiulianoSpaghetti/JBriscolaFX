package org.altervista.numerone.javafx;

import java.util.Vector;

public interface GiocatoreHelper {
	int Gioca(Vector<Carta> v, int i);
	int Gioca(Vector<Carta> v, Carta c, int i);
	int GetPunteggio(Carta c, Carta c1);
	void Paint(String nome, Vector<Carta> mano, int iCartaGiocata);
}
