# Tabacchi24h
Documento dei Requisiti 
1. Premesse del progetto 
1.1 Obiettivi e scopo del prodotto 
. Il prodotto è ideato per rispondere all’esigenza dei clienti delle tabaccherie di acquistare prodotti durante tutte le 24 ore giornaliere. Le scorte del venditore automatico sono rifornite in base alle quantità presenti. Il macchinario evita anche la vendita illecita di articoli ai minori grazie ad un sistema di scanner. 
1.2 Contesto di Business 
. È stato rilevato il bisogno di prodotti di privativa durante gli orari di chiusura. Il dipartimento punta anche a facilitare l’andamento della vendita degli articoli tramite un tracciamento automatico. Il resoconto è fornito su apposito file digitale.
1.3 Stakeholder 
. Le figure che influenzano lo sviluppo del sistema sono:
* Developers (programmatori)
* Docenti
2. Servizi del sistema 
2.1 Requisiti funzionali 
2.1.1 Il sistema dovrà consentire lo startup
* I codici di default dei prodotti indicati al requisito 2.2.1 saranno impostati dall’acquirente in fase di configurazione.
* La legenda dei prodotti verrà salvato su file sulla memoria del dispositivo.
2.1.2 Il sistema dovrà consentire la lettura del documento di identità
* Il sistema tramite una videocamera scannerizza il codice a barre presente sul retro del documento di identità
* Il sistema decifra il codice e ricava l’anno e il mese di nascita del cliente calcolandone l’età
2.1.3 Il sistema dovrà consentire la vendita degli articoli
* In base all’età calcolata nel punto 2.1.2 il sistema offre una scelta dei prodotti idonei alla vendita
* Il sistema rileva tramite un tastierino numerico la scelta dell’acquirente
2.1.4 Il sistema dovrà consentire la catalogazione delle vendite
* Una volta scelta e venduta la merce il sistema creerà un file specifico al giorno corrente contenente i dati sulle vendite
2.1.5 Il sistema dovrà consentire il rifornimento
* Ad ogni vendita il sistema controlla le scorte presenti e nel caso di bassa disponibilità provvede all’ordine degli articoli
2.2 Requisiti informativi 
2.2.1 Le informazioni amministrative del venditore automatico di riferimento sono:
* Nome prodotto
* Codice prodotto
* Fascia di età
* Prezzo
* Quantità
2.2.2 Il file delle vendite contiene:
* Informazione del punto 2.2.1
* La quantità venduta
* La data della vendita
2.2.3 Il file delle scorte contiene:
* La quantità degli articoli nella macchinetta

3. Vincoli di sistema 
Vincoli di sistema
3.1 Requisiti di interfaccia 
L'interfaccia proposta dal programma, sfruttando tutte le funzionalità dell'ambiente operativo tramite monitor lcd, permette quindi anche all'utente non specializzato di avvicinarsi al programma con facilità.
3.2 Requisiti di prestazione 
Non si registrano particolari esigenze in merito alle prestazioni
3.3 Requisiti di sicurezza 
Il sistema permette la vendita in base alla fascia d’età riconosciuta dal documento di
identità
3.4 Requisiti operativi 
Presenza di memoria centrale e una memoria principale per l’esecuzione del programma
3.5 Requisiti politici e legali 
Il sistema non memorizzerà i dati ricavati dalle scansioni dei documenti e dal tipo di prodotti venduti
3.6 Altri vincoli 
Questa sezione è vuota.
