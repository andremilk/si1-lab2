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

import java.util.*;

import static play.data.Form.form;

public class Application extends Controller {

    private static GenericDAO dao = new GenericDAO();
    private List<Anuncio> anuncios;

    public static Result index() {
        return redirect(controllers.routes.Application.verAnuncios());
    }

    public static Result criarAnuncio() {
        return ok(criaranuncio.render("Jamify :D"));
    }

    @Transactional
    public static Result verAnuncios() {
        List<Anuncio> anuncios = dao.findAllByClass(Anuncio.class);
        Collections.sort(anuncios, new Comparator<Anuncio>() {
            public int compare(Anuncio a1, Anuncio a2) {
                return a1.getData().getTime() < a2.getData().getTime() ? 1 : -1;
            }
        });
        return ok(index.render(anuncios));
    }


    @Transactional
    public static Result novoAnuncio() {
        DynamicForm dynamicForm = form().bindFromRequest();
        Form<Anunciante> anuncianteForm = form(Anunciante.class);
        Form<Anuncio> anuncioForm = form(Anuncio.class);

        Anunciante anunciante = anuncianteForm.bindFromRequest().get();
        anunciante.setContatos(dynamicForm.get("email"), dynamicForm.get("fb"));
        anunciante.setInstrumentos(Arrays.asList(dynamicForm.get(("instrumentos")).split("\\s*,\\s*")));
        anunciante.setGosta(Arrays.asList(dynamicForm.get(("gosta")).split("\\s*,\\s*")));
        anunciante.setDesgosta(Arrays.asList(dynamicForm.get(("desgosta")).split("\\s*,\\s*")));
        dao.persist(anunciante);

        Anuncio anuncio = anuncioForm.bindFromRequest().get();
        anuncio.setAnunciante(anunciante);
        anuncio.setData(new Date());
        dao.persist(anuncio);
        return redirect(controllers.routes.Application.verAnuncios());
    }

    @Transactional
    public static Result fazerBusca() {
        DynamicForm dynamicForm = form().bindFromRequest();
        String[] chave = dynamicForm.get("busca").split("\\s*,\\s*");

        List<Anuncio> resultadoBusca = new ArrayList<Anuncio>();
        List<Anuncio> anuncios = dao.findAllByClass(Anuncio.class);
        for (Anuncio anuncio : anuncios) {
            for (String c: chave) {
                switch (c) {
                    case "ocasional":
                        if (anuncio.getAnunciante().getOcasional())
                            resultadoBusca.add(anuncio);
                        break;
                    case "banda":
                        if (!anuncio.getAnunciante().getOcasional())
                            resultadoBusca.add(anuncio);
                        break;
                    default:
                        if (anuncio.getDescricao().contains(c) ||
                                anuncio.getAnunciante().getInstrumentos().contains(c) ||
                                anuncio.getAnunciante().getGosta().contains(c))
                            resultadoBusca.add(anuncio);
                        break;
                }
            }
        }
        return ok(index.render(resultadoBusca));

    }
}
