package br.com.aaefl.pfm.midias.adapter.datastore.mapper;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.AulaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.DisciplinaEntity;
import br.com.aaefl.pfm.midias.core.model.Aula;
import br.com.aaefl.pfm.midias.core.model.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AulaMapper {

    AulaMapper INSTANCE = Mappers.getMapper(AulaMapper.class);

    AulaEntity aulaToEntity(Aula aula);


    List<Aula> aulaToEntity(List<AulaEntity> aulasByIdDisciplina);

    Aula entityToAula(AulaEntity aulaEntity);
}
