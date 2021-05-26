package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioFrameAulaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioFrameAulaPK;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.FramesMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.UsuarioFrameAulaMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.FramesPageRepository;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.FramesRepository;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.UsuarioFrameAulaRepository;
import br.com.aaefl.pfm.midias.core.model.Frames;
import br.com.aaefl.pfm.midias.core.model.UsuarioFrameAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioFrameAulaService {

    @Autowired
    UsuarioFrameAulaRepository usuarioFrameAulaRepository;

    @Autowired
    FramesService framesService;

    @Autowired
    FramesPageRepository framesPageRepository;

    @Autowired
    FramesRepository framesRepository;

    public UsuarioFrameAula create(UsuarioFrameAula usuarioFrameAula, MultipartFile multipartFile) throws IOException, URISyntaxException {

        Frames frame = framesService.createFrame(multipartFile);

        usuarioFrameAula.setCodFrame(frame.getIdFrame());
        usuarioFrameAulaRepository.save(UsuarioFrameAulaMapper.INSTANCE.usuarioFrameAulatoEntity(usuarioFrameAula));

        return usuarioFrameAula;
    }

    public List<Frames> findFrames(String idDisciplina, String idAula, String idAluno, int size, int page) throws ChangeSetPersister.NotFoundException {
        Pageable paginacao = PageRequest.of(page,size);
        List<String> idFrames = new ArrayList<>();

        if(idAluno == null){
            List<UsuarioFrameAulaEntity> usuarioFrameAulaEntities = usuarioFrameAulaRepository.buscaPorAula(idAula);
            usuarioFrameAulaEntities.forEach(u -> idFrames.add(u.getCodFrame()));
        }else{
            List<UsuarioFrameAulaEntity> usuarioFrameAulaEntities = usuarioFrameAulaRepository.buscaPorAulaAluno(idAula,idAluno);
            usuarioFrameAulaEntities.forEach(u -> idFrames.add(u.getCodFrame()));
        }
        List<Frames> framesJooj = FramesMapper.INSTANCE.entityListToList(framesRepository.findAllById(idFrames));

        return framesJooj;
    }
}
