package br.com.cadeiras.rest;

import br.com.cadeiras.dto.CadeiraDto;
import br.com.cadeiras.models.CadeiraModel;
import br.com.cadeiras.service.CadeiraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCadeiras {
    @Autowired
    CadeiraRepository cadeiraRepository;
    @PostMapping("/cadastrarCadeira")
    public ResponseEntity<CadeiraModel> cadastrar(@RequestBody @Valid CadeiraDto cadeiraDto){
        var cadeiraModel = new CadeiraModel();
        BeanUtils.copyProperties(cadeiraDto,cadeiraModel);
        return ResponseEntity.status(HttpStatus.OK).body(cadeiraRepository.save(cadeiraModel));
    }
}
