# JBriscolaFX
JBriscolaFX: porting in java di wxBriscola. Simulatore del gioco della briscola a due giocatori senza multiplayer.

Per la compilazione ha bisogno delle librerie javafx.

https://gluonhq.com/products/javafx/

# Installazione su Windows
E' necessaria la jre 17 o superiore per poter aprire il programma.
Stando alle mie ricerche, oracle ha dismesso la jre pubblicando solo il JDK, che sarebbe il tool di sviluppo, che però su windows soffre di diverse lacune, è meglio usare la OpenJDK 18, scaricabile all'indirizzo https://jdk.java.net/18/ .

# Come localizzare il programma

Per localizzare il programma basta dotarsi di eclipse o di qualsiasi altro editor visuale, scaricare uno dei files JBriscolaFX_xy.properties e localizzare tutto quello che è a destra del simbolo "=".
A questo punto, bisogna rinominare il file usando la nominazione a due caratteri della traduzione (se prendete JBriscolaFX_it.properties e volete localizzare in tedesco bisogna rinominarlo in JBriscolaFX_de.properties).
A questo punto è sufficiente avviare il programma passando come parametri "-Duser.language=xy -Duser.region=XY" per vedere il programma localizzato (esempio java -Duser.language=fr -Duser.region=FR -jar ./Jbriscola-0.4.2.jar).

Se volete mandarmi le vostre localizzazioni sarò felice di immetterle nel programma origibnale e darvi darvi il credit.
Ricordatevi che la GPL obbliga a mantenere i credits originali, quindi, per fare, fate i seri...

# Sviluppi futuri
Oltre a fare la grafica in Java FX, è opportuno effettuare la derivazione delle classi helper per sfruttare i socket al fine di ottenere un multiplayer alla tetrinet.
Se volete farlo, siete liberi di poterlo sviluppare e di mandarmi i sorgenti come pull request, sarà mia premura mettervi tra gli sviluppatori del programma.
Se, invece, volete produrre traduzioni di qualsiasi genere, siete comunque liberi di mandarmele, sempre facendo la pull request, in questo modo verrete inseriti tra i traduttori del programma

