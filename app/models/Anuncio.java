package models;

import java.util.Date;
import java.util.Map;

/**
 * Created by andreluiz on 5/12/15.
 */
public class Anuncio {
    private String descricao;
    private String titulo;
    private Anunciante anunciante;
    private Date data;
    private String codigo;

    public Anuncio() {}
    public Anuncio(Anunciante anunciante, String codigo, Date data, String descricao, String titulo) {
        this.anunciante = anunciante;
        this.codigo = codigo;
        this.data = data;
        this.descricao = descricao;
        this.titulo = titulo;
    }

    public Map<String, String> getContatos() {
        return this.getAnunciante().getContatos();
    }
    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "anunciante=" + anunciante +
                ", descricao='" + descricao + '\'' +
                ", titulo='" + titulo + '\'' +
                ", data=" + data +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
