package br.org.clavedesol.CrudJava.service;

import br.org.clavedesol.CrudJava.controller.CreateInstrumentoDto;
import br.org.clavedesol.CrudJava.controller.UpdateInstrumentoDto;
import br.org.clavedesol.CrudJava.entity.Instrumento;
import br.org.clavedesol.CrudJava.entity.Oficineiro; // Importar a entidade Oficineiro
import br.org.clavedesol.CrudJava.repository.InstrumentoRepository;
import br.org.clavedesol.CrudJava.repository.OficineiroRepository; // Importar o repositório de Oficineiro
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstrumentoService {

    private final InstrumentoRepository instrumentoRepository;
    private final OficineiroRepository oficineiroRepository; // Repositório do Oficineiro

    public InstrumentoService(InstrumentoRepository instrumentoRepository, OficineiroRepository oficineiroRepository) {
        this.instrumentoRepository = instrumentoRepository;
        this.oficineiroRepository = oficineiroRepository; // Inicializar o repositório do Oficineiro
    }

    public UUID createInstrumento(CreateInstrumentoDto createInstrumentoDto) {
        // Buscar o Oficineiro pelo ID
        Oficineiro oficineiro = oficineiroRepository.findById(UUID.fromString(createInstrumentoDto.oficineiroId()))
                .orElseThrow(() -> new RuntimeException("Oficineiro não encontrado"));

        // DTO -> ENTITY
        var entity = new Instrumento(
                UUID.randomUUID(),
                createInstrumentoDto.nomeInstrumento(),
                createInstrumentoDto.tempoAprendizado(),
                createInstrumentoDto.fotoInstrumento(),
                oficineiro // Associar o Oficineiro encontrado
        );

        var instrumentoSaved = instrumentoRepository.save(entity);
        return instrumentoSaved.getIdInstrumento();
    }

    public Optional<Instrumento> getInstrumentoById(String instrumentoId) {
        return instrumentoRepository.findById(UUID.fromString(instrumentoId));
    }

    public List<Instrumento> listInstrumentos() {
        return instrumentoRepository.findAll();
    }

    public void updateInstrumentoById(String instrumentoId, UpdateInstrumentoDto updateInstrumentoDto, OficineiroService oficineiroService) {
        var instrumentoExist = instrumentoRepository.findById(UUID.fromString(instrumentoId));
        if (instrumentoExist.isPresent()) {
            var instrumento = instrumentoExist.get();
            if (updateInstrumentoDto.nomeInstrumento() != null) {
                instrumento.setNomeInstrumento(updateInstrumentoDto.nomeInstrumento());
            }

            if (updateInstrumentoDto.tempoAprendizado() > 0) {
                instrumento.setTempoAprendizado(updateInstrumentoDto.tempoAprendizado());
            }

            if (updateInstrumentoDto.fotoInstrumento() != null) {
                instrumento.setFotoInstrumento(updateInstrumentoDto.fotoInstrumento());
            }

            if (updateInstrumentoDto.oficineiroId() != null) {
                Optional<Oficineiro> oficineiroOptional = oficineiroRepository.findById(UUID.fromString(updateInstrumentoDto.oficineiroId()));
                if (oficineiroOptional.isPresent()) {
                    instrumento.setOficineiro(oficineiroOptional.get()); // Atribui o objeto Oficineiro
                } else {
                    throw new RuntimeException("Oficineiro não encontrado");
                }

            }
            instrumentoRepository.save(instrumento);
        }

    }
    public void deleteInstrumento(String instrumentoId) {
        var instrumentoExist = instrumentoRepository.existsById(UUID.fromString(instrumentoId));

        if (instrumentoExist) {
            instrumentoRepository.deleteById(UUID.fromString(instrumentoId));
        }
    }
}
