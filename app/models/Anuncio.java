package models;

import java.util.Date;
import java.util.Map;
import javax.persistence.*;

/**
 * Created by andreluiz on 5/12/15.
 */
@Entity
@Table(name = "ANUNCIO")
public class Anuncio {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "titulo")
    private String titulo;

    @OneToOne
    @JoinColumn(name = "criador")
    private Anunciante criador;

    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    @Column(name = "codigo")
    private String codigo;

    public Anuncio() {}

    public Anuncio(Anunciante criador, String codigo, Date data, String descricao, String titulo) {
        this.criador = criador;
        this.codigo = codigo;
        this.data = data;
        this.descricao = descricao;
        this.titulo = titulo;
    }

    public Map<String, String> getContatos() {
        return this.getAnunciante().getContatos();
    }
    public Anunciante getAnunciante() {
        return criador;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.criador = anunciante;
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
                "criador=" + criador +
                ", descricao='" + descricao + '\'' +
                ", titulo='" + titulo + '\'' +
                ", data=" + data +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anuncio anuncio = (Anuncio) o;

        if (id != anuncio.id) return false;
        if (getDescricao() != null ? !getDescricao().equals(anuncio.getDescricao()) : anuncio.getDescricao() != null)
            return false;
        if (getTitulo() != null ? !getTitulo().equals(anuncio.getTitulo()) : anuncio.getTitulo() != null) return false;
        if (getAnunciante() != null ? !getAnunciante().equals(anuncio.getAnunciante()) : anuncio.getAnunciante() != null)
            return false;
        if (getData() != null ? !getData().equals(anuncio.getData()) : anuncio.getData() != null) return false;
        return !(getCodigo() != null ? !getCodigo().equals(anuncio.getCodigo()) : anuncio.getCodigo() != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        result = 31 * result + (getTitulo() != null ? getTitulo().hashCode() : 0);
        result = 31 * result + (getAnunciante() != null ? getAnunciante().hashCode() : 0);
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        result = 31 * result + (getCodigo() != null ? getCodigo().hashCode() : 0);
        return result;
    }

    public int getId() {
        return this.id;
    }
}
