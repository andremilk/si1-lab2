import org.junit.*;

import org.specs2.time.Time;
import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest extends WithBrowser {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     *
     */
/*

    @Test
    public void deveListarAnunciosPorData() throws Exception {
        browser.goTo("http://localhost:" + testServer.port() + "/criarAnuncio");
        assertThat(browser.pageSource()).contains("Criação de Anúncio");
        Time t = Time.now();
        preencherFormulatio(browser, t);
        browser.submit("#criarBotao");
        browser.goTo("http://localhost:" + testServer.port() + "/criarAnuncio");
        Time t1 = Time.now();
        preencherFormulatio(browser, t1);
        browser.submit("#criarBotao");
        String source = browser.pageSource();

        assertThat(source.indexOf(t.toString()) > source.indexOf(t1.toString()));


    }

    private void preencherFormulatio(TestBrowser browser, Time t) {
        browser.fill("#tituloInput").with("Teste de título" + t);
        browser.fill("#codigoInput").with("codigo" + t);
        browser.fill("#descricaoInput").with("descricao " + t);
        browser.fill("#instrumentosInput").with("instrbla,instruble");
        browser.fill("#gostosInput").with("gostbla,gostble");
        browser.fill("#desgostosInput").with("desgobla,desgosble");
        browser.fill("#cidadeInput").with("cidade" + t);
        browser.fill("#bairroInput").with("bairro" + t);
        browser.fill("#emailInput").with(t+"@.com");
        browser.fill("#fbInput").with("http://" + t + ".com/ble");
        browser.click("#ocasional");
    }
    */
}
