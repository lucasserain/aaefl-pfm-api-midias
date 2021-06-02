package br.com.aaefl.pfm.midias.adapter.http.controller;

import br.com.aaefl.pfm.midias.core.service.UsuarioService;
import br.com.aaefl.pfm.midias.core.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/usuarios")
public class UsuariosController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuarios> getUsuarios(@RequestParam(value= "page", required = false) Optional<Integer> pageR,
                                      @RequestParam(value="size", required = false) Optional<Integer> sizeR,
                                      @RequestParam(value="nome", required = false) Optional<String> nome,
                                      @RequestParam(value="tipo", required = false) Optional<Integer> tipoR){

        int page =0;
        int size =10;
        int tipo = 1;
        if(pageR.isPresent()){
            page = pageR.get();
        }
        if(sizeR.isPresent()){
            size = sizeR.get();
        }
        if(tipoR.isPresent()){
            tipo = tipoR.get();
        }

        return usuarioService.findUsuarios(size, page, nome,tipo);

    }

    @GetMapping(value="{/idUsuario}")
    public List<Usuarios> getUsuario(@RequestParam(value= "page", required = false) Optional<Integer> pageR,
                                      @RequestParam(value="size", required = false) Optional<Integer> sizeR,
                                     @RequestParam(value="nome", required = false) Optional<String> nome,
                                     @PathVariable("idUsuario") String idUsuario){

        int page =0;
        int size =10;
        if(pageR.isPresent()){
            page = pageR.get();
        }
        if(sizeR.isPresent()){
            size = sizeR.get();
        }

       // return usuarioService.findUsuarioById(idUsuario,size, page);
        return null;
    }
}
