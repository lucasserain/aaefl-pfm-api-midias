package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.DisciplinaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuariosEntity;
import br.com.aaefl.pfm.midias.core.model.Disciplina;
import br.com.aaefl.pfm.midias.core.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DisciplinaMapper {

    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

    DisciplinaEntity disciplinaToEntity(Disciplina disciplina);

    List<Disciplina> disciplinaEntityListToDisciplina(List<DisciplinaEntity> all);
}
