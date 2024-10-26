package br.org.clavedesol.CrudJava.controller;

import br.org.clavedesol.CrudJava.entity.Instrumento;

import java.util.List;

public record UpdateOficineiroDto(String nomeOficineiro, int idadeOficineiro, int tempoEmpresa, String fotoOficineiro, List<Instrumento> instrumentos) {
}
