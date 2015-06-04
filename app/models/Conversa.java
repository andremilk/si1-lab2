package models;

import javax.persistence.*;

/**
 * Created by andreluiz on 6/4/15.
 */
@Entity
@Table(name = "CONVERSA")
public class Conversa {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "pergunta")
    private String pergunta;

    @Column(name = "resposta")
    private String resposta;



    public Conversa(String pergunta) {
        this.pergunta = pergunta;
        this.resposta = new String();
    }

    public void adicionarResposta(String resposta) {
        this.setResposta(resposta);
    }

    public Conversa() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Conversa{" +
                "id=" + id +
                ", pergunta='" + pergunta + '\'' +
                ", resposta='" + resposta + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
