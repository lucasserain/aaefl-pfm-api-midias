package br.com.aaefl.pfm.midias.adapter.http.controller;

import br.com.aaefl.pfm.midias.core.model.Aula;
import br.com.aaefl.pfm.midias.core.model.Disciplina;
import br.com.aaefl.pfm.midias.core.model.Usuarios;
import br.com.aaefl.pfm.midias.core.model.VideoFrame;
import br.com.aaefl.pfm.midias.core.service.DisciplinaService;
import br.com.aaefl.pfm.midias.core.service.UsuarioFrameAulaService;
import br.com.aaefl.pfm.midias.core.service.exception.ObjectAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping(value="/{idProfessor}")
    public ResponseEntity<?> create(@PathVariable("idProfessor") String idProfessor, @Valid @RequestBody Disciplina disciplina) throws ObjectAlreadyExistsException {
        return  ResponseEntity.ok().body(disciplinaService.create(idProfessor,disciplina));
    }

    @PostMapping(value="/{idDisciplina}/aula")
    public ResponseEntity<?> createAula(@PathVariable("idDisciplina") String idDisciplina, @Valid @RequestBody Aula aula) throws ObjectAlreadyExistsException {
        return  ResponseEntity.ok().body(disciplinaService.createAula(idDisciplina,aula));
    }

    @PostMapping(value="/{idDisciplina}/aluno/{idAluno}")
    public ResponseEntity<?> createAula(@PathVariable("idDisciplina") String idDisciplina, @PathVariable("idAluno") String idAluno) throws ObjectAlreadyExistsException {
        return  ResponseEntity.ok().body(disciplinaService.relacionaAluno(idDisciplina,idAluno));
    }

    @GetMapping
    public ResponseEntity<?> get() throws ObjectAlreadyExistsException {
        return  ResponseEntity.ok().body(disciplinaService.bucaDisciplinas());
    }

    @GetMapping(value="{idDisciplina}")
    public ResponseEntity<?> get(@PathVariable("idDisciplina") String idDisciplina){
        return  ResponseEntity.ok().body(disciplinaService.bucaDisciplina(idDisciplina));
    }

    @GetMapping(value="{idDisciplina}/professor")
    public ResponseEntity<?> getProfessor(@PathVariable("idDisciplina") String idDisciplina){
        return  ResponseEntity.ok().body(disciplinaService.buscaProfessor(idDisciplina));
    }


    @GetMapping(value="{idDisciplina}/aulas")
    public ResponseEntity<?> getAulasDisciplina(@PathVariable("idDisciplina") String idDisciplina){
        return  ResponseEntity.ok().body(disciplinaService.buscaAulasPorDisciplina(idDisciplina));
    }
    @GetMapping(value="{idDisciplina}/alunos")
    public ResponseEntity<?> getAlunosDisciplina(@PathVariable("idDisciplina") String idDisciplina){
        return  ResponseEntity.ok().body(disciplinaService.buscaAlunosPorDisciplina(idDisciplina));
    }


}
