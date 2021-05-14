package br.com.aaefl.pfm.midias.adapter.http.controller;

import br.com.aaefl.pfm.midias.core.model.UsuarioFrameAula;
import br.com.aaefl.pfm.midias.core.service.UsuarioFrameAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value="/frames")
public class FramesController {

    @Autowired
    UsuarioFrameAulaService usuarioFrameAulaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam(value="file") MultipartFile multipartFile, UsuarioFrameAula usuarioFrameAula) throws IOException, URISyntaxException {

        usuarioFrameAulaService.create(usuarioFrameAula,multipartFile);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/oi")
    public ResponseEntity<?> jooj(@RequestParam(name="file") MultipartFile multipartFile) throws IOException, URISyntaxException {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
