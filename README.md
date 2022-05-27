# JBriscolaFX
JBriscolaFX: porting in java di wxBriscola. Simulatore del gioco della briscola a due giocatori senza multiplayer.

Per la compilazione ha bisogno delle librerie javafx.

https://gluonhq.com/products/javafx/

# Installazione su Windows
E' necessaria la jre 17 o superiore per poter aprire il programma.
Stando alle mie ricerche, oracle ha dismesso la jre pubblicando solo il JDK, che sarebbe il tool di sviluppo, che però su windows soffre di diverse lacune, è meglio usare la OpenJDK 18, scaricabile all'indirizzo https://jdk.java.net/18/ .

# Come avviare il JAR
Per avviare il JAR, sia sotto windows che sotto linux, è necessaria la openjdk e le librerie JavaFX i cui link sono nei parametri precedenti.

Purtroppo nel jar non vengono incluse le librerie fx, a ragione perché sono system dependent, per cui bisogna specificare a mano due parametri: il module èpath (cioé dove trovare le librerie) e add modules (cioé quali librerie caricare).

Vi semplifico il lavoro:

java -jar ./JBriscolaFX-0.1-openjdk.jar --module-path path a javafx-sdk-18.0.1/lib/ --add-modules=javafx.base

![screen-2022-05-27-03-29-47](https://user-images.githubusercontent.com/49764967/170610530-8898afc1-bf21-453b-b4a6-1c29244e3ab6.png)
<img width="614" alt="Immagine 2022-05-27 034206" src="https://user-images.githubusercontent.com/49764967/170612122-466afa59-a2e1-4562-82cd-12160426e820.png">


E' possibile specificare anche le -Duser.language e -Duser.region per indicare quale locale caricare. Attualmente sono supportati 4 locale: it, es, fr e en.

![screen-2022-05-27-03-29-47](https://user-images.githubusercontent.com/49764967/170610541-aa30be42-2cd5-45c8-a70c-b758fa5554e0.png)


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

