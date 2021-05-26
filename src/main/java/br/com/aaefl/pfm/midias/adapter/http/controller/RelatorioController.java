package br.com.aaefl.pfm.midias.adapter.http.controller;

import br.com.aaefl.pfm.midias.core.model.Frames;
import br.com.aaefl.pfm.midias.core.service.UsuarioFrameAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/relatorios")
public class RelatorioController {

    @Autowired
    UsuarioFrameAulaService usuarioFrameAulaService;


    @GetMapping(value="/{idDisciplina}")
    public List<Frames> getReport(@PathVariable("idDisciplina") String idDisciplina,
                                  @RequestParam(value ="idAula", required = true) String idAula,
                                  @RequestParam(value = "idAluno", required = false) String idAluno,
                                  @RequestParam(value= "page", required = false) Optional<Integer> pageR,
                                  @RequestParam(value="size", required = false) Optional<Integer> sizeR ) throws ChangeSetPersister.NotFoundException {

        int page =0;
        int size =10;
        if(pageR.isPresent()){
            page = pageR.get();
        }
        if(sizeR.isPresent()){
            size = sizeR.get();
        }

        List<Frames> frames = usuarioFrameAulaService.findFrames(idDisciplina, idAula, idAluno, size, page);

        return frames;
    }
}
