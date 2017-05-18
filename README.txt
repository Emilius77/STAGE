NOTE DI PROGETTO

WAS: Glassfish
DB: derby, versione embedded, configurato in Glassfish come DataSource JTA
Maven
Persistence framework: JPA + Hibernate 5
EJB
JAX-RS

plugin eclipse consigliati:
* egit (per github)
* dbeaver (per accederere al DB)
* glassfish tools (connettore al server glassfish)


== INSTALLAZIONE ==
-- DERBY --
<<<<<<< Upstream, based on branch 'master' of https://github.com/luca-vercelli/orchestratore.git
* scompattare il db (vuoto) dbOrchestratore.7z dalla directory Utility/db, es. in c:\miopercorso\dbOrchestratore
  (non � necessario installare derby server, perch� utilizziamo la versione embedded)


-- GLASSFISH --
* scaricare e installare glassfish. Il link seguente porta direttamente alla pagina download,
  scegliere la versione GF 4.1.2 - Full Platform :
  https://javaee.github.io/glassfish/download
  Installazione di default in C:\glassfish4
* creare il server glassfish in eclipse, questo crea in automatico una cartella di dominio:
  glassfish4/glassfish/domains/domain1
* *non* deployare ancora nulla nel dominio
* Installazione di default in C:\glassfish4
* Operazioni da eseguire da Eclipse (Menu Windows -> Show view -> Servers)
* Tasto dx, new, server
* Nella finestra "Define new server" selezionare Glassfish, lasciare "localhost" come hostname, immettere un server name (di solito si lascia quello di default),
* cliccare su next.
* Nella pagina seguente ci verr� richiesto il path dell'installazione (esempio: C:\glassfish4\glassfish\domains\domain1), mettere la spunta su:
* "use JAR archive for deployment" e cliccare su next.
* Consigliato lasciare la password di admin vuota!!!
* Nella pagina seguente cliccare su finish  (*non* deployare ancora nulla nel dominio). L'aggiunta del progetto in glassfish (per il deployment) 
* la si far� successivamente alla configurazione dei Data source.


--- AGGIUNTA FILE NECESSARI PER IL DATASOURCE DERBY ---
* Copiare i "derby*.jar" contenuti nella cartella Utility/jar nella cartella c:\glassfish4\glassfish\domains\domain1\lib\ext
* Copiare jboss-logging-3.3.0.Final.jar (dalla cartella Utiliy/jar) in c:\glassfish4\glassfish\module


--- CONFIGURAZIONE DATASOURCE DERBY ---
* Avviare (o riavviare) il server glassfish da Eclipse 
* Aprire un browser e inserire l'indirizzo "http://localhost:4848/" per accedere alla console di amministrazione
* (1) men� JDBC -> JDBC Connection Pool -> New:
** Pool name: orchestratore
** Resources type: javax.sql.DataSource
** Database Driver Vendor: Embedded-Derby-30
* cliccare su next e andare in fondo alla nuova pagina e nella tabella "Additional Properties" impostare il seguente parametro:
** DatabaseName: inserire il percorso assoluto del db (es. c:\miopercorso\dbOrchestratore)
** rimuovere tutte le altre voci
* (2) men� JDBC -> JDBC Resources -> New
**  JNDI name: jdbc/orchestratore 
**  poolname: orchestratore

--- CREAZIONE DELLE TABELLE ---
Attualmente, le tabelle vengono cancellate e ricreate automaticamente a ogni avvio.
Per evitarlo, rimuovere l'opzione "drop-and-create" nel file persistence.xml.

--- POPOLAMENTO DELLE TABELLE CON DATI DI DEFAULT ---
(TODO)
=======
* scompattare il db (vuoto) dbOrchestratore.7z dalla directory Utility/db, in una cartella a piacere
  (non � necessario installare derby server, perch� utilizziamo la versione embedded)


-- GLASSFISH --
* scaricare e installare glassfish. Il link seguente porta direttamente alla pagina download,
  scegliere la versione GF 4.1.2 - Full Platform :
  https://javaee.github.io/glassfish/download
  Installazione di default in C:\glassfish4
* creare il server glassfish in eclipse, questo crea in automatico una cartella di dominio:
  glassfish4/glassfish/domains/domain1
* *non* deployare ancora nulla nel dominio
* Installazione di default in C:\glassfish4
* Operazioni da eseguire da Eclipse (Menu Windows -> Show view -> Servers)
* Tasto dx, new, server
* Nella finestra "Define new server" selezionare Glassfish, lasciare "localhost" come hostname, immettere un server name (di solito si lascia quello di default),
* cliccare su next.
* Nella pagina seguente ci verr� richiesto il path dell'installazione (esempio: C:\glassfish4\glassfish\domains\domain1), mettere la spunta su:
* "use JAR archive for deployment" e cliccare su next.
* Consigliato lasciare la password di admin vuota!!!
* Nella pagina seguente cliccare su finish  (*non* deployare ancora nulla nel dominio). L'aggiunta del progetto in glassfish (per il deployment) 
* la si far� successivamente alla configurazione dei Data source.

--- AGGIUNTA FILE NECESSARI PER IL DATASOURCE DERBY ---
* Aggiungere i "derby*.jar" contenuti nella cartella Utility/jar nella cartella c:\glassfish4\glassfish\domains\domain1\lib\ext
* Copiare il file jboss-logging-3.3.0.Final.jar (dalla cartella Utiliy/jar) in c:\glassfish4\glassfish\module

--- CONFIGURAZIONE DATASOURCE DERBY ---
* Avviare il server glassfish da Eclipse (se non si � avviato in automatico) 
* Aprire un browser e inserire l'indirizzo "http://localhost:4848/" per accedere alla console di amministrazione
* (1) men� JDBC -> JDBC Connection Pool -> New:
** Pool name: orchestratore
** Resources type: javax.sql.DataSource
** Database Driver Vendor: Embedded-Derby-30
* cliccare su next e andare in fondo alla nuova pagina e nella tabella "Additional Properties" impostare il seguente parametro:
** DatabaseName: inserire il percorso assoluto del db (nel nostro caso c:\workspace\dbOrchestratore)
** rimuovere tutte le altre voci
** VARIANTE: se si imposta anche il parametro createDatabase=true il db verr� creato in automatico se non esiste
* (2) men� JDBC -> JDBC Resources -> New
**  JNDI name: jdbc/orchestratore 
**  poolname: orchestratore
>>>>>>> 3b2e3e9 completata documentazione

