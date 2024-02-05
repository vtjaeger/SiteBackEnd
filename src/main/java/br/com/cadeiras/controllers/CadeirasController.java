package br.com.cadeiras.controllers;

import br.com.cadeiras.models.CadeiraModel;
import br.com.cadeiras.service.CadeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cadeiras")
@CrossOrigin(origins = "http://localhost:3000")
public class CadeirasController {
    @Autowired
    CadeiraRepository cadeiraRepository;
    @GetMapping
    public ResponseEntity<List<CadeiraModel>> listarCadeiras(){
        List<CadeiraModel> cadeiras = cadeiraRepository.findAll();

        return ResponseEntity.ok().body(cadeiras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadeiraModel> detalhesCadeira(@PathVariable(value = "id") UUID id){
        Optional<CadeiraModel> cadeiraOpcional = cadeiraRepository.findById(id);
        if(cadeiraOpcional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cadeiraOpcional.get());
        }
    }

}
