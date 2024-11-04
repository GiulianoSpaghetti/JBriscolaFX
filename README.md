# JBriscolaFX
JBriscolaFX: porting in java di wxBriscola. Simulatore del gioco della briscola a due giocatori senza multiplayer.

Per la compilazione ha bisogno delle librerie javafx.

https://gluonhq.com/products/javafx/

## ATTENZIONE
Java puoi essere usato per polarizzare il sistema operativo e/o l'hardware 

# Installazione su Windows
E' necessaria la jre 17 o superiore per poter aprire il programma.
Stando alle mie ricerche, oracle ha dismesso la jre pubblicando solo il JDK, che sarebbe il tool di sviluppo, che però su windows soffre di diverse lacune, è meglio usare la OpenJDK 18, scaricabile all'indirizzo https://jdk.java.net/18/ .

# Come avviare il JAR
Per avviare il JAR, sia sotto windows che sotto linux, è necessaria la openjdk e le librerie JavaFX i cui link sono nei paragrafi precedenti.

Purtroppo nel jar non vengono incluse le librerie fx, a ragione perché sono system dependent, per cui bisogna specificare a mano due parametri: il module path (cioé dove trovare le librerie) e add modules (cioé quali librerie caricare).

Vi semplifico il lavoro:

java -jar ./JBriscolaFX-0.1-openjdk.jar --module-path path a javafx-sdk-18.0.1/lib/ --add-modules=javafx.base

![screen-2022-05-27-03-29-47](https://user-images.githubusercontent.com/49764967/170612556-9f2053df-50df-42fe-a480-a0e1b23461f3.png)

<img width="614" alt="Immagine 2022-05-27 034206" src="https://user-images.githubusercontent.com/49764967/170612122-466afa59-a2e1-4562-82cd-12160426e820.png">


E' possibile specificare anche le -Duser.language e -Duser.region per indicare quale locale caricare. Attualmente sono supportati 4 locale: it, es, fr e en.

![screen-2022-05-27-03-29-47](https://user-images.githubusercontent.com/49764967/170612584-869e6953-e32a-4a7e-8a4f-4e65ade0f2c3.png)

Il jar è compatibile pure con la java virtual machine di oracle, solo che su windows per compilare i sorgenti è necessaria la openjdk.

Il jar non è compatibile con la virtual machine Microsoft, installata da Visual STudio 2022.

<img width="359" alt="Immagine 2022-05-27 063145" src="https://user-images.githubusercontent.com/49764967/170629333-c6ac0ac5-218a-495c-a297-aa0fe1cb34db.png">

<img width="376" alt="Immagine 2022-05-27 070505" src="https://user-images.githubusercontent.com/49764967/170633185-4acf4ea4-fdd3-4b70-a156-54752e4f826b.png">

<img width="614" alt="Immagine 2022-05-27 055109" src="https://user-images.githubusercontent.com/49764967/170625897-72c49271-5652-4702-bebb-cbbcc6e68ea6.png">

E' però possibile usare eclipse per compilare i sorgenti java generici con la openjdk di microsoft, basta farla puntare all'indirizzo evidenziato nella seconda schermata; solo che per ricompilare la JBriscolaFX occorrono anche le librerie Java FX per OpenJDK 11, che sono in supporto esteso e quindi bisogna farne esplicita richiesta.

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

# Donazioni

http://numerone.altervista.org/donazioni.php

