package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.FramesEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.FramesMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.FramesRepository;
import br.com.aaefl.pfm.midias.core.model.Frames;
import br.com.aaefl.pfm.midias.core.service.exception.ObjectAlreadyExistsException;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class FramesService {

    @Autowired
    FramesRepository framesRepository;

    @Autowired
    S3Service s3Service;

    public Frames createFrame(MultipartFile multipartFile) throws IOException, URISyntaxException {

        String codFrame = multipartFile.getOriginalFilename();
        Optional<FramesEntity> frameFromDB = framesRepository.findById(codFrame);

        Frames frame = Frames.builder()
                .idFrame(codFrame)
                .urlFrame(uploadFramePicture(multipartFile).toString())
                .dataCriacao(LocalDateTime.now())
                .build();

        if(frameFromDB.isEmpty()){
            framesRepository.save(FramesMapper.INSTANCE.framesToFramesEntity(frame));
        }else{
            new ObjectAlreadyExistsException("Frame já cadastrado: " + frame.getIdFrame() + ", Tipo: " + Frames.class.getName());
        }

        return frame;
    }


    public URI uploadFramePicture(MultipartFile multipartFile) throws IOException, URISyntaxException {
        return s3Service.uploadFile(multipartFile);
    }
}
