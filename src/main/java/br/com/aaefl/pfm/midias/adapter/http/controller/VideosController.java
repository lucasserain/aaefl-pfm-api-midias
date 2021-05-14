package br.com.aaefl.pfm.midias.adapter.http.controller;

import br.com.aaefl.pfm.midias.core.model.UsuarioFrameAula;
import br.com.aaefl.pfm.midias.core.model.UsuarioVideoAula;
import br.com.aaefl.pfm.midias.core.service.UsuarioFrameAulaService;
import br.com.aaefl.pfm.midias.core.service.UsuarioVideoAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value="/videos")
public class VideosController {

    @Autowired
    UsuarioVideoAulaService usuarioVideoAulaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam(value="file") MultipartFile multipartFile, UsuarioVideoAula usuarioVideoAulaAula) throws IOException, URISyntaxException {

        usuarioVideoAulaService.create(usuarioVideoAulaAula,multipartFile);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
