package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioFrameAulaEntity;
import br.com.aaefl.pfm.midias.core.model.Frames;
import br.com.aaefl.pfm.midias.core.model.UsuarioFrameAula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioFrameAulaMapper {

    UsuarioFrameAulaMapper INSTANCE = Mappers.getMapper(UsuarioFrameAulaMapper.class);

    @Mapping(source = "codFrame", target = "codFrame")
    UsuarioFrameAulaEntity usuarioFrameAulatoEntity(UsuarioFrameAula usuarioFrameAula);
}
