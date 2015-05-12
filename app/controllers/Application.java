package controllers;

import models.Anuncio;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    private List<Anuncio> anuncios;
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result criarAnuncio() {
        return Results.TODO;
    }

    public static Result verAnuncios() {
        return Results.TODO;
    }


}
