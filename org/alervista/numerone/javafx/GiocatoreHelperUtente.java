package org.altervista.numerone.javafx;

import java.util.Scanner;
import java.util.Vector;

public class GiocatoreHelperUtente implements GiocatoreHelper {

	@Override
	public int Gioca(Vector<Carta> v, int i) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s;
		do {
			for (int indice=0; indice<v.size(); indice++) {
				System.out.print(v.get(indice));
				if (JBriscoFXMain.ch.getCartaBriscola().StessoSeme(v.get(indice)))
					System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
			System.out.print(JBriscoFXMain.bundle.getString("InserireIndice")+": ");
			s=in.next();
			try {i=Integer.parseInt(s);}
			catch (java.lang.NumberFormatException e) {i=-1;}
			i--;
			if (i<0 || i>=v.size())
				System.out.println(JBriscoFXMain.bundle.getString("NumeroNonCorretto"));
		} while (i<0 || i>=v.size());
		return i;
	}

	@Override
	public int Gioca(Vector<Carta> v, Carta c, int i) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s;
		do {
			for (int indice=0; indice<v.size(); indice++) {
				System.out.print(v.get(indice));
				if (JBriscoFXMain.ch.getCartaBriscola().StessoSeme(v.get(indice)))
					System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
			System.out.print(JBriscoFXMain.bundle.getString("InserireIndice")+": ");
			s=in.next();
			try {i=Integer.parseInt(s);}
			catch (java.lang.NumberFormatException e) {i=-1;}
			i--;
			if (i<0 || i>=v.size())
				System.out.println(JBriscoFXMain.bundle.getString("NumeroNonCorretto"));
		} while (i<0 || i>=v.size());
		return i;
	}

	@Override
	public int GetPunteggio(Carta c, Carta c1) {
		// TODO Auto-generated method stub
		return c.GetPunteggio()+c1.GetPunteggio();
	}

	@Override
	public void Paint(String nome, Vector<Carta> mano, int iCartaGiocata) {
		// TODO Auto-generated method stub
		System.out.println(JBriscoFXMain.bundle.getString("CarteDi")+": "+ nome);
		int i;
		for (i=0; i<mano.size(); i++)
			if (i!=iCartaGiocata)
			System.out.print(mano.get(i)+" ");
		if (mano.size()>iCartaGiocata)
			System.out.println(JBriscoFXMain.bundle.getString("CartaGiocata")+": "+mano.get(iCartaGiocata));
		System.out.println();
	}

}
