package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.mapper.UsuarioVideoAulaMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.UsuarioVideoAulaRepository;

import br.com.aaefl.pfm.midias.core.model.UsuarioVideoAula;
import br.com.aaefl.pfm.midias.core.model.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class UsuarioVideoAulaService {

    @Autowired
    UsuarioVideoAulaRepository usuarioVideoAulaRepository;

    @Autowired
    VideosService videosServiceService;

    public UsuarioVideoAula create(UsuarioVideoAula usuarioVideoAula, MultipartFile multipartFile) throws IOException, URISyntaxException {

        Videos video = videosServiceService.createVideo(multipartFile);

        usuarioVideoAula.setCodVideo(video.getIdVideo());
        usuarioVideoAulaRepository.save(UsuarioVideoAulaMapper.INSTANCE.usuarioVideoAulatoEntity(usuarioVideoAula));

        return usuarioVideoAula;
    }
}
