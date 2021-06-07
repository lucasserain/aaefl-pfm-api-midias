package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.AlunoDisciplinaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.AulaEntity;
import br.com.aaefl.pfm.midias.core.model.AlunoDisciplina;
import br.com.aaefl.pfm.midias.core.model.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

import java.util.Optional;

@Mapper
public interface AlunoDisciplinaMapper {

    AlunoDisciplinaMapper INSTANCE = Mappers.getMapper(AlunoDisciplinaMapper.class);

    AlunoDisciplinaEntity alunoDisciplinaToEntity(AlunoDisciplina alunoDisciplina);

}
