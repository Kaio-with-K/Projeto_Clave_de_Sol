package br.org.clavedesol.CrudJava.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "tbl_oficineiros")
public class Oficineiro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idOficineiro;

    @Column(name = "nome_oficineiro", length = 80, nullable = false)
    private String nomeOficineiro;

    @Column(name = "idade_oficineiro", nullable = false)
    private int idadeOficineiro;

    @Column(name = "tempo_de_empresa", nullable = true)
    private int tempoEmpresa;

    @Column(name = "foto_oficineiro")
    private String fotoOficineiro;

    @OneToMany (mappedBy = "oficineiro")
    private List<Instrumento> instrumentos;


    public Oficineiro() {
    }

    public Oficineiro(UUID idOficineiro, String nomeOficineiro, int idadeOficineiro, int tempoEmpresa, String fotoOficineiro, List<Instrumento> instrumentos) {
        this.idOficineiro = idOficineiro;
        this.nomeOficineiro = nomeOficineiro;
        this.idadeOficineiro = idadeOficineiro;
        this.tempoEmpresa = tempoEmpresa;
        this.fotoOficineiro = fotoOficineiro;
        this.instrumentos = instrumentos;
    }

    public UUID getIdOficineiro() {
        return idOficineiro;
    }

    public void setIdOficineiro(UUID idOficineiro) {
        this.idOficineiro = idOficineiro;
    }

    public String getNomeOficineiro() {
        return nomeOficineiro;
    }

    public void setNomeOficineiro(String nomeOficineiro) {
        this.nomeOficineiro = nomeOficineiro;
    }

    public int getIdadeOficineiro() {
        return idadeOficineiro;
    }

    public void setIdadeOficineiro(int idadeOficineiro) {
        this.idadeOficineiro = idadeOficineiro;
    }

    public int getTempoEmpresa() {
        return tempoEmpresa;
    }

    public void setTempoEmpresa(int tempoEmpresa) {
        this.tempoEmpresa = tempoEmpresa;
    }

    public String getFotoOficineiro() {
        return fotoOficineiro;
    }

    public void setFotoOficineiro(String fotoOficineiro) {
        this.fotoOficineiro = fotoOficineiro;
    }

    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }
}
