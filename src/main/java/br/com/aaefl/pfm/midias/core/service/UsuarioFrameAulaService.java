package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.FramesEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.FramesMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.VideoFramesMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.FramesPageRepository;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.FramesRepository;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.FrameVideoRepository;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.VideosPageRepository;
import br.com.aaefl.pfm.midias.core.model.Frames;
import br.com.aaefl.pfm.midias.core.model.VideoFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UsuarioFrameAulaService {

    @Autowired
    FrameVideoRepository frameVideoRepository;

    @Autowired
    FramesService framesService;

    @Autowired
    FramesPageRepository framesPageRepository;

    @Autowired
    VideosPageRepository videosPageRepository;

    @Autowired
    FramesRepository framesRepository;

    public VideoFrame create(VideoFrame videoFrame, MultipartFile multipartFile) throws IOException, URISyntaxException {

        Frames frame = framesService.createFrame(multipartFile);

        videoFrame.setCodFrame(frame.getIdFrame());
        frameVideoRepository.save(VideoFramesMapper.INSTANCE.usuarioFrameAulatoEntity(videoFrame));

        return videoFrame;
    }

    public List<Frames> findFrames(String idDisciplina, String idAula, String idAluno, int size, int page) throws ChangeSetPersister.NotFoundException {
        Pageable paginacao = PageRequest.of(page,size);
        List<String> idsVideo = new ArrayList<String>();
        List<String> listaFrames = new ArrayList<String>();

        if(idAluno == null){
            idsVideo = videosPageRepository.buscaVideoPorAula(idAula);
        }else{
            idsVideo = videosPageRepository.buscaVideoPorAulaAluno(idAula,idAluno);
        }

        idsVideo.forEach( v ->  listaFrames.addAll(frameVideoRepository.buscaIdFramePorVideo(v)));

        List<Frames> framesJooj = FramesMapper.INSTANCE.entityListToList(framesRepository.findAllById(listaFrames));

        return framesJooj;
    }

    public List<Frames> findFramesByClass(String idAula, String idAluno, int size, int page) {
        Pageable paginacao = PageRequest.of(page,size);
        List<String> idsVideo = new ArrayList<String>();
        List<String> listaFrames = new ArrayList<String>();

        if(idAluno == null){
            idsVideo = videosPageRepository.buscaVideoPorAula(idAula);
        }else{
            idsVideo = videosPageRepository.buscaVideoPorAulaAluno(idAula,idAluno);
        }

        idsVideo.forEach( v ->  listaFrames.addAll(frameVideoRepository.buscaIdFramePorVideo(v)));
        List<FramesEntity> framesEntity = framesRepository.findAllById(listaFrames);
        framesEntity.sort(Comparator.comparing(FramesEntity::getTempoFrame));
        return FramesMapper.INSTANCE.entityListToList(framesEntity);

    }
}
