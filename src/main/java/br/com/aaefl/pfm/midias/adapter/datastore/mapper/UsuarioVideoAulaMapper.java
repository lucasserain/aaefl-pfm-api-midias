package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioVideoAulaEntity;
import br.com.aaefl.pfm.midias.core.model.UsuarioVideoAula;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioVideoAulaMapper {

    UsuarioVideoAulaMapper INSTANCE = Mappers.getMapper(UsuarioVideoAulaMapper.class);

    @Mapping(source = "codVideo", target = "codVideo")
    UsuarioVideoAulaEntity usuarioVideoAulatoEntity(UsuarioVideoAula usuarioVideoAula);
}
