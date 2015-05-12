package models;

import play.data.validation.Constraints;

import java.util.*;

/**
 * Created by andreluiz on 5/12/15.
 */
public class Anunciante {
    private String cidade;
    private String bairro;
    private List<String> instrumentos;
    private List<String> gosta;
    private List<String> desgosta;
    private Map<String, String> contatos;
    /**
     * True se for ocasional, False se estiver atras de uma banda.
     */
    private Boolean ocasional;

    /**
     * Construtor da classe Anunciante que recebe contatos separadamente.
     * @param cidade Cidade do anunciante.
     * @param bairro Bairro do anunciante.
     * @param instrumentos Array de Strings com instrumentos que o anunciante toca.
     * @param gosta Array de Strings com estilos que o anunciante gosta.
     * @param desgosta Array de Strings com estilos que o anunciante não gosta.
     * @param email Email válido.
     * @param facebook Link do fb.
     * @param ocasional true se o anunciante está buscando algo ocasional, senão false.
     */
    public Anunciante(String cidade, String bairro, String[] instrumentos, String[] gosta, String[] desgosta, String email, String facebook, Boolean ocasional) {
        this.setContatos(contatos.get("email"), contatos.get("fb"));
        this.setInstrumentos(Arrays.asList(instrumentos));
        this.setGosta(Arrays.asList(gosta));
        this.setDesgosta(Arrays.asList(desgosta));

        this.ocasional = ocasional;
        this.cidade = cidade;
        this.bairro = bairro;
        this.setContatos(email, facebook);
    }

    /**
     * Construtor de Anunciante que recebe contatos em um Map.
     * @param cidade Cidade do anunciante.
     * @param bairro Bairro do anunciante.
     * @param instrumentos Lista de Strings com os instrumentos que o anunciante toca.
     * @param gosta Lista de Strings com os estilos que o anunciante gosta.
     * @param desgosta Lista de Strings com estilos que o anunciante não gosta.
     * @param contatos Map de String em String, cuja chave pode ser email ou fb.
     * @param ocasional true se o anunciante está buscando algo ocasional, senão false.
     */
    public Anunciante(String cidade, String bairro, List<String> instrumentos, List<String> gosta, List<String> desgosta, Map<String, String> contatos, Boolean ocasional) {
        this.setContatos(contatos.get("email"), contatos.get("fb"));
        this.setInstrumentos(instrumentos);
        this.setGosta(gosta);
        this.setDesgosta(desgosta);

        this.ocasional = ocasional;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Map<String, String> getContatos() {
        return contatos;
    }

    public void setContatos(Map<String, String> contatos) {
        this.contatos = contatos;
    }

    /**
     * Se não houver pelo menos um contato, uma IllegalArgumentException será lançada.
     * @param email Email válido.
     * @param facebook
     */
    public void setContatos(String email, String facebook) {
        if((facebook == null) && ((email == null) || !(new Constraints.EmailValidator().isValid(email))))
            throw new IllegalArgumentException("Pelo menos um contato deve ser fornecido");
        HashMap<String, String> tmp = new HashMap<String, String>();
        tmp.put("email", email);
        tmp.put("fb", facebook);
        this.setContatos(tmp);
    }

    public List<String> getDesgosta() {
        return desgosta;
    }

    /**
     *
     * @param desgosta Se null, uma ArrayList de String é criada.
     */
    public void setDesgosta(List<String> desgosta) {
        if((desgosta != null))
            this.desgosta = desgosta;
        else
            this.desgosta = new ArrayList<String>();
    }

    public List<String> getGosta() {
        return gosta;
    }

    /**
     *
     * @param gosta Se null, um ArrayList de String é criado.
     */
    public void setGosta(List<String> gosta) {
        if((gosta != null))
            this.gosta = gosta;
        else
            this.gosta = new ArrayList<String>();    }

    public List<String> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<String> instrumentos) {
        if((instrumentos == null) || (instrumentos.size() < 1))
            throw new IllegalArgumentException("O anunciante deve indicar ao menos um instrumento");
        this.instrumentos = instrumentos;
    }

    public Boolean getOcasional() {
        return ocasional;
    }

    public void setOcasional(Boolean ocasional) {
        this.ocasional = ocasional;
    }
}

