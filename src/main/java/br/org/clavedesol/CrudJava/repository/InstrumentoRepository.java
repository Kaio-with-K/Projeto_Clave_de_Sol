package br.org.clavedesol.CrudJava.repository;

import br.org.clavedesol.CrudJava.entity.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, UUID> {
}
