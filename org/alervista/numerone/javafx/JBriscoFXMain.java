package org.altervista.numerone.javafx;

import java.util.Locale;
import java.util.ResourceBundle;

import org.altervista.numerone.javafx.CartaHelper.RISULTATI_COMPARAZIONE;

public class JBriscoFXMain {
	public static ResourceBundle bundle= ResourceBundle.getBundle("JBriscolaFX", Locale.getDefault());
	public static void main(String[] args) {
		ElaboratoreCarteBriscola e = new ElaboratoreCarteBriscola(true);
		Mazzo m = new Mazzo(e);
		CartaHelperBriscola ch=new CartaHelperBriscola(e);
		Carta.Inizializza(40, ch);
		Giocatore g = new Giocatore(new GiocatoreHelperUtente(), "Giulio",  true, 3);
		Giocatore cpu = new Giocatore(new GiocatoreHelperCpu(e.GetCartaBriscola()), "Cpu", true, 3);
		Giocatore primo = g;
		Giocatore secondo = cpu;
		Giocatore temp = g;
		Carta c;
		Carta c1;
		Carta briscola = Carta.GetCarta(e.GetCartaBriscola());
		String vers = "0.1";
		//out.WriteLine($"CBriscola {vers} {mgr.GetString("AdOperaDi")} Giulio Sorrentino. {mgr.GetString("Traduzione")} {mgr.GetString("AdOperaDi")} {mgr.GetString("Autore")}.");
		for (int i = 0; i < 3; i++)
		{
			g.AddCarta(m);
			cpu.AddCarta(m);
		}
		while (true)
		{
			if (m.GetNumeroCarte() > 0)
			{
				System.out.println(bundle.getString("LaCartaDiBriscolaE")+": "+e.GetCartaBriscola());
				System.out.println(bundle.getString("NelMazzoRimangono")+": "+m.GetNumeroCarteStr()+" "+bundle.getString("carte")+".");
			}
			System.out.println(bundle.getString("PuntiDi")+ " "+ cpu.GetNome()+": "+cpu.GetPunteggioStr()); ;
			System.out.println(bundle.getString("PuntiDi")+" "+g.GetNome()+": "+g.GetPunteggio());
			primo.Gioca(0);
			if (primo == cpu)
				System.out.println(bundle.getString("LaCartaGiocataE")+": "+primo.GetCartaGiocata());
			secondo.Gioca(primo, 0);

			c = primo.GetCartaGiocata();
			c1 = secondo.GetCartaGiocata();
			System.out.println(c+" " +c1);

			if ((Carta.Compara(c,c1) == RISULTATI_COMPARAZIONE.MAGGIORE_LA_SECONDA && c.StessoSeme(c1)) || (c1.StessoSeme(briscola) && !c.StessoSeme(briscola)))
			{
				temp = secondo;
				secondo = primo;
				primo = temp;
			}
			primo.AggiornaPunteggio(secondo);
			try
			{
				primo.AddCarta(m);
				secondo.AddCarta(m);
			}
			catch (java.util.NoSuchElementException e1)
			{
				System.out.println(bundle.getString("PartitaFinita")+".");
				System.out.println(bundle.getString("PuntiDi")+ " "+ cpu.GetNome()+": "+cpu.GetPunteggioStr()); ;
				System.out.println(bundle.getString("PuntiDi")+" "+g.GetNome()+": "+g.GetPunteggio());
				if (g.GetPunteggio() == cpu.GetPunteggio())
					System.out.println(bundle.getString("PartitaPatta")+".");
				else
					if (g.GetPunteggio() > cpu.GetPunteggio())
					System.out.println(bundle.getString("HaiVintoPer")+" "+(g.GetPunteggio() - cpu.GetPunteggio())+" "+bundle.getString("punti")+".");
				else
					System.out.println(bundle.getString("HaiPersoPer")+" "+(cpu.GetPunteggio() - g.GetPunteggio())+" "+bundle.getString("punti")+".");

				return;
			}
		}
	}

}
