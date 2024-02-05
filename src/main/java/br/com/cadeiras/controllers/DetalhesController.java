package br.com.cadeiras.controllers;

import br.com.cadeiras.models.CadeiraModel;
import br.com.cadeiras.service.CadeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Controller
public class DetalhesController {
    @Autowired
    CadeiraRepository cadeiraRepository;
    @GetMapping("/cadeiras/detalhesCadeira/885beeed-6501-46fd-bbb5-94050ca312a9")
    public String detalhesCadeira(@PathVariable(value = "id") UUID id, Model model){
        Optional<CadeiraModel> cadeiraModelOptional = cadeiraRepository.findById(id);
        if (cadeiraModelOptional.isPresent()) {
            CadeiraModel cadeiraModel = cadeiraModelOptional.get();
            model.addAttribute("cadeira", cadeiraModel);
            return "detalhesCadeira";
        } else {
            return "redirect:/erro";
        }
    }
}
