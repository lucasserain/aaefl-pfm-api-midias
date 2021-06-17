package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.VideosEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.VideosMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.VideosRepository;
import br.com.aaefl.pfm.midias.core.model.Videos;
import br.com.aaefl.pfm.midias.core.service.exception.ObjectAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VideosService {

    @Autowired
    VideosRepository videosRepository;

    @Autowired
    S3Service s3Service;

    public Videos createVideo(MultipartFile multipartFile) throws IOException, URISyntaxException {

        String codVideo = multipartFile.getOriginalFilename();
        Optional<VideosEntity> videoFromDB = videosRepository.findById(codVideo);

        Videos videos = Videos.builder()
                .idVideo(codVideo)
                .urlVideo(uploadFramePicture(multipartFile).toString()+".mp4")
                .dataCriacao(LocalDateTime.now())
                .build();

        if(videoFromDB.isEmpty()){
            videosRepository.save(VideosMapper.INSTANCE.videoToEntity(videos));
        }else{
            new ObjectAlreadyExistsException("Frame já cadastrado: " + videos.getIdVideo() + ", Tipo: " + Videos.class.getName());
        }

        return videos;
    }


    public URI uploadFramePicture(MultipartFile multipartFile) throws IOException, URISyntaxException {
        return s3Service.uploadFile(multipartFile);
    }
}
