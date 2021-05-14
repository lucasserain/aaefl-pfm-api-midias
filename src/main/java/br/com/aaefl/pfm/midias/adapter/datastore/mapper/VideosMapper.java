package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.FramesEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.VideosEntity;
import br.com.aaefl.pfm.midias.core.model.Frames;
import br.com.aaefl.pfm.midias.core.model.Videos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VideosMapper {

    VideosMapper INSTANCE = Mappers.getMapper(VideosMapper.class);

    @Mapping(source = "idVideo", target = "idVideo")
    VideosEntity videoToEntity(Videos video);
}
