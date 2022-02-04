# projectwork-agenzia_immobiliare

Applicazione gestionale di immobili in vendita o in affitto.

L'applicazione presenta due sezioni principali, una di gestione amministrativa e una di servizio per la clientela.
Non è ancora implementata l'auteticazione dunque le due sezioni sono raggiungibili soltanto inserendo l'url corrispondente. L'idea era quella di implementare 
un tasto visibile solo da un utente di tipo amministratore che reindirizzava alla parte admin, dunque non accessibile dai clienti.

Nella parte amministrativa è possibile aggiungere un nuovo immobile (che corrisponde anche ad aggiungere un nuovo annuncio nella parte home per i clienti)
con tutti i campi come il numero delle stanze, dei balconi o la classe energetica o ancora aggiungere le foto descrittive dell'immobile. Una volta aggiunto e
salvato correttamente, viene displayato in una tabella da dove è possibile andare a modificarlo. In questa pagina nel form compaiono due checkbox in più,
una per indicare che l'immobile è stato venduto o affittato, e uno per annullare definitivamente l'immobile.
Come per gli immobili, lo stesso processo è stato creato anche per gli agenti immobiliari e i clienti, ognuno avente la propria pagina in cui venire elencati in tabella.

Infine, la pagina home della parte admin contiene altre tabelle che comprendono dati utili inerenti agli agenti e appuntamenti (appuntamenti prossimi e affari 
completati dagli agenti..) o sugli immobili (i più visualizzati o i più recenti).

La parte della clientela invece si presenta con un'immagine che copre tutta la view-height della home, al centro della quale si trovano dei campi che servono
a filtrare la ricerca degli annunci secondo gli interessi dell'utente. Scorrendo la pagina si può trovare già un primo elenco degli annunci sotto forma di card.
Contengono poche informazioni, una singola foto rappresentativa dell'immobile e un link "info" che porta direttamente al dettaglio di quell'annuncio. 

Dalla form dei filtri (che si può anche lasciare vuota e reindirizza alla pagina degli annunci filtrati senza filtrare effettivamente nessun oggetto) si passa a
una pagina contenente la lista degli annunci filtrati con informazioni aggiuntive, un carosello di immagini e un tasto mi piace. Da qui, cliccando sul link di un 
annuncio (link che corrisponde al titolo) si può andare alla pagina di dettaglio, in cui sono presenti ulteriori informazioni e un carosello di immagini più grande
che permette una migliore visualizzazione. Un tasto "contattaci" permette di andare su una pagina di form, in cui è possibile prenotare un appuntamento con un 
agente immobiliareper l'annuncio e quindi immobile corrispondente. L'utente deve inserire la sua email, e se è registrato può procedere con la prenotazione, 
altrimenti verrà reindirizzato a una pagina differente di form, in cui sono presenti anche i campi utili alla registrazione anche dell'utente stesso.
Un ultimo controllo avviene sulla data e orario della prenotazione. Se esiste già un appuntamento per quell'immobile, con quella data e quell'orario, l'utente
dovrà reinserire i dati poichè impossibilitato a completare l'operazione.
