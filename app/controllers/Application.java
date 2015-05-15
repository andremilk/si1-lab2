package controllers;

import models.Anunciante;
import models.Anuncio;
import models.dao.GenericDAO;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Call;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.criaranuncio;
import views.html.index;

import java.util.Date;
import java.util.List;

import static play.data.Form.form;

public class Application extends Controller {

    private static GenericDAO dao = new GenericDAO();
    private List<Anuncio> anuncios;

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result criarAnuncio() {
        return ok(criaranuncio.render("Jamify :D"));
    }

    @Transactional
    public static Result verAnuncios() {
        List<Anuncio> anuncios = dao.findAllByClass(Anuncio.class);
        return ok(anuncios.toString());
    }


    @Transactional
    public static Result novoAnuncio() {
        DynamicForm dynamicForm = form().bindFromRequest();
        Form<Anunciante> anuncianteForm = form(Anunciante.class);
        Form<Anuncio> anuncioForm = form(Anuncio.class);

        Anunciante anunciante = anuncianteForm.bindFromRequest().get();
        anunciante.setContatos(dynamicForm.get("email"), dynamicForm.get("fb"));
        dao.persist(anunciante);
        Anuncio anuncio = anuncioForm.bindFromRequest().get();
        anuncio.setAnunciante(anunciante);
        anuncio.setData(new Date());
        dao.persist(anuncio);
        return redirect(controllers.routes.Application.verAnuncios());
    }
}
