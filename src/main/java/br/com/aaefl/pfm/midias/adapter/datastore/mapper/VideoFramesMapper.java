package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.VideoFramesEntity;
import br.com.aaefl.pfm.midias.core.model.VideoFrame;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VideoFramesMapper {

    VideoFramesMapper INSTANCE = Mappers.getMapper(VideoFramesMapper.class);

    @Mapping(source = "codVideo", target = "codVideo")
    @Mapping(source = "codFrame", target = "codFrame")
    VideoFramesEntity usuarioFrameAulatoEntity(VideoFrame videoFrame);
}
