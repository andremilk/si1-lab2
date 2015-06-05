import models.Anunciante;
import models.Anuncio;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.Timestamp;
import java.util.Date;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    private Anuncio anuncio;
    private Anunciante anunciante;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        anunciante = new Anunciante("Campina Grande", "Bodocongó", new String[]{"pandeiro"}, new String[]{"axé"}, new String[]{"pop"}, "andre.guimaraes.leite@gmail.com", null, true);
        anuncio = new Anuncio(anunciante, "123mudar", new Timestamp((new Date()).getTime()), "Ae galera, alguém de bodocongas quer tocar um pagodão?", "Em busca do pagode");

    }

    @Test
    public void anuncianteDeveTerCamposObrigatorios() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pelo menos um contato deve ser fornecido");
        anunciante = new Anunciante("Campina Grande", "Bodocongó", new String[]{"pandeiro"}, null, null, null, null, true);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pelo menos um contato deve ser fornecido");
        anunciante = new Anunciante("Campina Grande", "Bodocongó", new String[]{"pandeiro"}, null, null, "", null, true);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pelo menos um contato deve ser fornecido");
        anunciante = new Anunciante("Campina Grande", "Bodocongó", new String[]{"pandeiro"}, null, null, "a@a", null, true);
    }


    @Test
    public void respostasSomenteComCodigo() {

        anuncio.adicionarPergunta("Pergunta teste?");
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Código inválido.");
        anuncio.adicionarResposta(0, "Resposta teste.", "codigo errado");

    }

    @Test
    public void testIndex() throws Exception {
        assert(true);
    }

    @Test
    public void testCriarAnuncio() throws Exception {
        anunciante.setContatos(null);
        anuncio = new Anuncio(anunciante, "123mudar", new Timestamp((new Date()).getTime()), "Ae galera, alguém de bodocongas quer tocar um pagodão?", "Em busca do pagode");

    }

    @Test
    public void testVerAnuncios() throws Exception {
        assert(true);
    }
}
