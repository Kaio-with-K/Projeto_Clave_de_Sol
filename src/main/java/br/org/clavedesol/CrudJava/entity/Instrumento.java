package br.org.clavedesol.CrudJava.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tbl_instrumentos")
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idInstrumento;

    @Column(name = "nome_instrumento", length = 20, nullable = false)
    private String nomeInstrumento;

    @Column(name = "tempo_aprendizado", nullable = false)
    private int tempoAprendizado;

    @Column(name = "foto_instrumento")
    private String fotoInstrumento;

    @ManyToOne
    @JoinColumn(name = "fk_id_oficineiro", nullable = false) // Chave estrangeira já definida aqui
    private Oficineiro oficineiro;

    public Instrumento() {
    }

    public Instrumento(UUID idInstrumento, String nomeInstrumento, int tempoAprendizado, String fotoInstrumento, Oficineiro oficineiro) {
        this.idInstrumento = idInstrumento;
        this.nomeInstrumento = nomeInstrumento;
        this.tempoAprendizado = tempoAprendizado;
        this.fotoInstrumento = fotoInstrumento;
        this.oficineiro = oficineiro;
    }

    public UUID getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(UUID idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public String getNomeInstrumento() {
        return nomeInstrumento;
    }

    public void setNomeInstrumento(String nomeInstrumento) {
        this.nomeInstrumento = nomeInstrumento;
    }

    public int getTempoAprendizado() {
        return tempoAprendizado;
    }

    public void setTempoAprendizado(int tempoAprendizado) {
        this.tempoAprendizado = tempoAprendizado;
    }

    public String getFotoInstrumento() {
        return fotoInstrumento;
    }

    public void setFotoInstrumento(String fotoInstrumento) {
        this.fotoInstrumento = fotoInstrumento;
    }

    public Oficineiro getOficineiro() {
        return oficineiro;
    }

    public void setOficineiro(Oficineiro oficineiro) {
        this.oficineiro = oficineiro;
    }
}
