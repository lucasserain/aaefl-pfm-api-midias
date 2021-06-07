package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuariosEntity;
import br.com.aaefl.pfm.midias.core.model.AlunoDisciplina;
import br.com.aaefl.pfm.midias.core.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuariosMapper {

    UsuariosMapper INSTANCE = Mappers.getMapper(UsuariosMapper.class);

    List<Usuarios> usuarioEntityPageToUsuarios(List<UsuariosEntity> usuariosEntityPage);

    @Mapping(source = "codUsuario", target = "codAluno")
    List<Usuarios> usuarioEntityPageToUsuarios(Iterable<UsuariosEntity> allById);
}
