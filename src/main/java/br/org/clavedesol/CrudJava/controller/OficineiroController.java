package br.org.clavedesol.CrudJava.controller;


import br.org.clavedesol.CrudJava.entity.Oficineiro;
import br.org.clavedesol.CrudJava.service.OficineiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/oficineiros")
public class OficineiroController {

    private OficineiroService oficineiroService;

    public OficineiroController(OficineiroService oficineiroService) {
        this.oficineiroService = oficineiroService;
    }

    @PostMapping
    public ResponseEntity<Oficineiro> createOficineiro(@RequestBody CreateOficineiroDto createOficineiroDto) {
        var oficeneiroID = oficineiroService.createOficineiro(createOficineiroDto);
        return ResponseEntity.created(URI.create("/oficineiros/" + oficeneiroID.toString())).build();
    }

    @GetMapping("/{idOficineiro}")
    public ResponseEntity<Oficineiro> getOficineiro(@PathVariable("idOficineiro") String idOficineiro) {
        var oficineiro = oficineiroService.getOficineiroById(idOficineiro);
        if (oficineiro.isPresent()) {
            return ResponseEntity.ok(oficineiro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Oficineiro>> listOficineiro() {
        var oficineiros = oficineiroService.listOficineiros();
        return ResponseEntity.ok(oficineiros);
    }

    @PutMapping("/{idOficineiro}")
    public ResponseEntity<Void> updateOficineiroById(@PathVariable("idOficineiro") String idOficineiro,
                                                     @RequestBody UpdateOficineiroDto updateOficineiroDto) {
        oficineiroService.updateOficineiroById(idOficineiro, updateOficineiroDto);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{idOficineiro}")
    public ResponseEntity<Void> deleteOficineiroById(@PathVariable("idOficineiro") String idOficineiro) {
        oficineiroService.deleteOficineiro(idOficineiro);
        return ResponseEntity.noContent().build();
    }

}
