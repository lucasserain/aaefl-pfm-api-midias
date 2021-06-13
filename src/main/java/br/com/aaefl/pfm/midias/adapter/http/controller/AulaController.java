package br.com.aaefl.pfm.midias.adapter.http.controller;

import br.com.aaefl.pfm.midias.core.model.Aula;
import br.com.aaefl.pfm.midias.core.model.Disciplina;
import br.com.aaefl.pfm.midias.core.service.AulaService;
import br.com.aaefl.pfm.midias.core.service.DisciplinaService;
import br.com.aaefl.pfm.midias.core.service.exception.ObjectAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/aulas")
public class AulaController {

    @Autowired
    AulaService aulaService;



    @GetMapping(value="{idAula}")
    public ResponseEntity<?> get(@PathVariable("idAula") String idAula){
        return  ResponseEntity.ok().body(aulaService.buscaAula(idAula));
    }


}
