package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.FramesEntity;
import br.com.aaefl.pfm.midias.core.model.Frames;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FramesMapper {

    FramesMapper INSTANCE = Mappers.getMapper(FramesMapper.class);

    @Mapping(source = "idFrame", target = "idFrame")
    FramesEntity framesToFramesEntity(Frames frames);

    List<Frames> entityListToList(List<FramesEntity> framesEntities);
}
