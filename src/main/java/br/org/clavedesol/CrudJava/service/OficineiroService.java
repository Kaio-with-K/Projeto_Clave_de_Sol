package br.org.clavedesol.CrudJava.service;

import br.org.clavedesol.CrudJava.controller.CreateOficineiroDto;
import br.org.clavedesol.CrudJava.controller.UpdateOficineiroDto;
import br.org.clavedesol.CrudJava.entity.Oficineiro;
import br.org.clavedesol.CrudJava.repository.InstrumentoRepository;
import br.org.clavedesol.CrudJava.repository.OficineiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OficineiroService {

    private final InstrumentoRepository instrumentoRepository;
    private OficineiroRepository oficineiroRepository;

    public OficineiroService(OficineiroRepository oficineiroRepository, InstrumentoRepository instrumentoRepository) {
        this.oficineiroRepository = oficineiroRepository;
        this.instrumentoRepository = instrumentoRepository;
    }

    public UUID createOficineiro(CreateOficineiroDto createOficineiroDto) {
        //DTO -> ENTITY
        var entity = new Oficineiro(
                UUID.randomUUID(),
                createOficineiroDto.nomeOficineiro(),
                createOficineiroDto.idadeOficineiro(),
                createOficineiroDto.tempoEmpresa(),
                createOficineiroDto.fotoOficineiro(),
                createOficineiroDto.instrumentos());

        var oficineiroSaved = oficineiroRepository.save(entity);
        return oficineiroSaved.getIdOficineiro();
    }

    public Optional<Oficineiro> getOficineiroById(String oficineiroId) {
        return oficineiroRepository.findById(UUID.fromString(oficineiroId));
    }

    public List<Oficineiro> listOficineiros() {
        return oficineiroRepository.findAll();
    }

    public void updateOficineiroById(String oficineiroId, UpdateOficineiroDto updateOficineiroDto) {
        var oficineiroExists = oficineiroRepository.findById(UUID.fromString(oficineiroId));
        if (oficineiroExists.isPresent()) {
            var oficineiro = oficineiroExists.get();
            if (updateOficineiroDto.nomeOficineiro() != null) {
                oficineiro.setNomeOficineiro(updateOficineiroDto.nomeOficineiro());
            }

            if (updateOficineiroDto.idadeOficineiro() > 0) {
                oficineiro.setIdadeOficineiro(updateOficineiroDto.idadeOficineiro());
            }

            if (updateOficineiroDto.tempoEmpresa() > 0) {
                oficineiro.setTempoEmpresa(updateOficineiroDto.tempoEmpresa());
            }

            if (updateOficineiroDto.fotoOficineiro() != null) {
                oficineiro.setFotoOficineiro(updateOficineiroDto.fotoOficineiro());
            }

            if (updateOficineiroDto.instrumentos() != null) {
                oficineiro.setInstrumentos(updateOficineiroDto.instrumentos());
            }

            oficineiroRepository.save(oficineiro);
        }
    }

    public void deleteOficineiro(String oficineiroId) {
        var oficineiroExists = oficineiroRepository.existsById(UUID.fromString(oficineiroId));
        if (oficineiroExists) {
            oficineiroRepository.deleteById(UUID.fromString(oficineiroId));
        }
    }
}
