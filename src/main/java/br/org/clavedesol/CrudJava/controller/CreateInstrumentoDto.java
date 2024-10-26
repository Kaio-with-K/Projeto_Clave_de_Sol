package br.org.clavedesol.CrudJava.controller;

import br.org.clavedesol.CrudJava.entity.Oficineiro;

public record CreateInstrumentoDto(String nomeInstrumento, int tempoAprendizado, String fotoInstrumento, String oficineiroId) {
}
