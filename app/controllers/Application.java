package controllers;

import models.Anunciante;
import models.Anuncio;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.criaranuncio;
import views.html.index;

import java.util.Date;
import java.util.List;

import static play.data.Form.form;

public class Application extends Controller {

    private List<Anuncio> anuncios;
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result criarAnuncio() {
        return ok(criaranuncio.render("Jamify :D"));
    }

    public static Result verAnuncios() {
        return Results.TODO;
    }


    public static Result novoAnuncio() {
        DynamicForm dynamicForm = form().bindFromRequest();
        Form<Anunciante> anuncianteForm = form(Anunciante.class);
        Form<Anuncio> anuncioForm = form(Anuncio.class);

        Anunciante anunciante = anuncianteForm.bindFromRequest().get();
        anunciante.setContatos(dynamicForm.get("email"), dynamicForm.get("fb"));
        Anuncio anuncio = anuncioForm.bindFromRequest().get();
        anuncio.setAnunciante(anunciante);
        anuncio.setData(new Date());

        return ok("ok, I recived POST data. That's all...");

    }
}
