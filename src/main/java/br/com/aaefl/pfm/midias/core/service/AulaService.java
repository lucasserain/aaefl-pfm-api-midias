package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.AulaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.AulaMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.AulaRepository;
import br.com.aaefl.pfm.midias.core.model.Aula;
import br.com.aaefl.pfm.midias.core.model.Disciplina;
import br.com.aaefl.pfm.midias.core.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AulaService {

    @Autowired
    AulaRepository aulaRepository;


    public Aula buscaAula(String idAula) {
        Optional<AulaEntity> aula = aulaRepository.findById(idAula);

        if(aula.isEmpty()){
            throw new ObjectNotFoundException("Não há aula cadastrada com esse id! Id: " + idAula + ", Tipo: " + Aula.class.getName());
        }
        return AulaMapper.INSTANCE.entityToAula(aula.get());
    }
}
