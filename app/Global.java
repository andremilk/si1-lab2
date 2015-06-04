/**
 * Created by andreluiz on 6/4/15.
 */
import models.Anunciante;
import models.Anuncio;
import play.*;

import models.dao.GenericDAO;
import play.db.jpa.JPA;

import java.util.Date;


public class Global extends GlobalSettings {

    private static GenericDAO DAO = new GenericDAO();

    @Override
    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");

        JPA.withTransaction(new play.libs.F.Callback0() {
            @Override
            public void invoke() throws Throwable {
                for (int i = 1; i < 26; i++) {

                    Anunciante anunciante = new Anunciante("Campina Grande", "Bodocongó", new String[]{"pandeiro"}, new String[]{"pandeiro", "berimbau"}
                                                            , new String[]{"guitarra"}, "a" + i + "@b.com", "http://fb.com/" + i, (i % 2 == 0) ? true: false);

                    DAO.persist(anunciante);
                    Anuncio anuncio = new Anuncio(anunciante, "123mudar", new Date(), "Ae galera, alguém de bodocongas quer tocar um pagodão?", "Em busca do pagode");


                    DAO.persist(anuncio);
                    DAO.flush();
                }
            }
        });
    }
}