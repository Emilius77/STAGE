package it.finsoft.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

@Stateless
@Path("reset")
public class WSReset {

	public final static Logger LOG = Logger.getLogger(WSReset.class);

	@PersistenceContext
	EntityManager manager;

	/**
	 * Questo e' un reset in GET quando si richiama la pagina, svuota le tabelle
	 * indicate nello scriptsql.txt e le ripopola, e' da ottimizzare ma per il
	 * momento funziona (ritorna un errore sulla prima istruzione)
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String reset() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("/script.sql")));
		String sql = "";
		while (reader.ready() == true) {
			try {
				sql = reader.readLine().toString();
				if (sql == null)
					continue;
				sql = sql.trim();
				if (sql.equals("") || sql.startsWith("--"))
					continue;
				// LOG.info(sql); // inutile, lo fa gi� Hibernate
				Query q = manager.createNativeQuery(sql);
				q.executeUpdate();
			} catch (Exception e) {
				LOG.error("Error while executing SQL command", e);
				break;
			}
		}
		reader.close();
		LOG.info("RESET effettuato con successo");
		return "RESET dati predefiniti DB effettuato";
	}

}