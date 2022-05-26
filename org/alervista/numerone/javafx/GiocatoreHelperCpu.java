package org.altervista.numerone.javafx;

import java.util.Random;
import java.util.Vector;

public class GiocatoreHelperCpu implements GiocatoreHelper {
	private Carta briscola;
	private Random rand;
	private int getBriscola(Vector<Carta> mano) {
		int i;
		for (i=0; i<mano.size() && !briscola.StessoSeme(mano.get(i)); i++);
		return i;
	}
	private int GetSoprataglio(Vector<Carta> mano, Carta c, boolean maggiore) {
		boolean trovata=false;
		int i;
		if (maggiore) {
			for (i=mano.size()-1; i>-1; i--)
				if (c.StessoSeme(mano.get(i)) && Carta.Compara(c, mano.get(i))==CartaHelper.RISULTATI_COMPARAZIONE.MAGGIORE_LA_SECONDA) {
					trovata=true;
					break;
				} else if(c.StessoSeme(mano.get(i)) && Carta.Compara(c, mano.get(i))==CartaHelper.RISULTATI_COMPARAZIONE.MAGGIORE_LA_PRIMA) {
					break;
				}
		} else {
				for(i=0; i<mano.size(); i++)
					if (c.StessoSeme(mano.get(i)) && Carta.Compara(c, mano.get(i))==CartaHelper.RISULTATI_COMPARAZIONE.MAGGIORE_LA_SECONDA) {
						trovata=true;
						break;
					}
		}
		if (trovata)
			return i;
		else
			return mano.size();
			
	}
	
	public GiocatoreHelperCpu(int b) {
		briscola=Carta.GetCarta(b);
		rand=new Random();
	}
	
	@Override
	public int Gioca(Vector<Carta> mano, int iCarta) {
		// TODO Auto-generated method stub
		int i;
		for (i=mano.size()-1; i>-1 && (mano.get(i).GetPunteggio()>5 || briscola.StessoSeme(mano.get(i))); i--);
		if (i<0 || i>mano.size())
			i=0;
		return i;
			
	}

	@Override
	public int Gioca(Vector<Carta> mano, Carta c, int i) {
		// TODO Auto-generated method stub
		i=rand.nextInt();
		if (!briscola.StessoSeme(c)) {
			if ((i=GetSoprataglio(mano, c, true))<mano.size())
				return i;
			if (c.GetPunteggio()>0 && (i=getBriscola(mano))<mano.size()) {
				if (c.GetPunteggio()>4)
					return i;
				if (mano.get(i).GetPunteggio()>0)
					if (i%10<5)
						return i;
			}
		} else {
			if (i%10<5 && (i=GetSoprataglio(mano, c, false))<mano.size())
				return i;
		}
		i=0;
		return 0;
	}

	@Override
	public int GetPunteggio(Carta c, Carta c1) {
		// TODO Auto-generated method stub
		return c.GetPunteggio()+c1.GetPunteggio();
	}
	@Override
	public void Paint(String nome, Vector<Carta> mano, int iCartaGiocata) {
		// TODO Auto-generated method stub
		int i;
		if (mano.size()>iCartaGiocata)
			System.out.println(JBriscoFXMain.bundle.getString("CartaGiocata")+": "+mano.get(iCartaGiocata));
		System.out.println();
	}

}
