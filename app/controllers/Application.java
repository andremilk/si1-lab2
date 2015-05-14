package controllers;

import models.Anuncio;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.criaranuncio;
import views.html.index;

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
        Logger.info("dados: " +         dynamicForm.toString());
        return ok("ok, I recived POST data. That's all..." +         dynamicForm.toString());
    }
}
