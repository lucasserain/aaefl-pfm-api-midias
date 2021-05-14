package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.mapper.UsuarioFrameAulaMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.UsuarioFrameAulaRepository;
import br.com.aaefl.pfm.midias.core.model.Frames;
import br.com.aaefl.pfm.midias.core.model.UsuarioFrameAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class UsuarioFrameAulaService {

    @Autowired
    UsuarioFrameAulaRepository usuarioFrameAulaRepository;

    @Autowired
    FramesService framesService;

    public UsuarioFrameAula create(UsuarioFrameAula usuarioFrameAula, MultipartFile multipartFile) throws IOException, URISyntaxException {

        Frames frame = framesService.createFrame(multipartFile);

        usuarioFrameAula.setCodFrame(frame.getIdFrame());
        usuarioFrameAulaRepository.save(UsuarioFrameAulaMapper.INSTANCE.usuarioFrameAulatoEntity(usuarioFrameAula));

        return usuarioFrameAula;
    }
}
