package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.AlunoDisciplinaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.AlunoDisciplinaPK;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.DisciplinaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.AlunoDisciplinaMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.AulaMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.DisciplinaMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.AlunoDisciplinaRepository;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.AulaRepository;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.DisciplinaRepository;
import br.com.aaefl.pfm.midias.core.model.AlunoDisciplina;
import br.com.aaefl.pfm.midias.core.model.Aula;
import br.com.aaefl.pfm.midias.core.model.Disciplina;
import br.com.aaefl.pfm.midias.core.service.exception.ObjectAlreadyExistsException;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    AulaRepository aulaRepository;

    @Autowired
    AlunoDisciplinaRepository alunoDisciplinaRepository;




    public Disciplina create(String idProfessor, Disciplina json) throws ObjectAlreadyExistsException {

        String uuid = UUID.randomUUID().toString();

        if(disciplinaRepository.findById(uuid).isPresent()){
            throw new  ObjectAlreadyExistsException("Disciplina já cadastrada! Id: " + uuid + ", Tipo: " + Disciplina.class.getName());
        }

        Disciplina disciplina = Disciplina.builder()
                .codDisciplina(uuid)
                .codProfessor(idProfessor)
                .nomeDisciplina(json.getNomeDisciplina())
                .descricao(json.getDescricao())
                .urlFundo(json.getUrlFundo())
                .build();

        disciplinaRepository.save(DisciplinaMapper.INSTANCE.disciplinaToEntity(disciplina));

        return disciplina;

    }

    public Aula createAula(String idDisciplina, Aula json) {
        Aula aula = Aula.builder()
                .codAula(UUID.randomUUID().toString())
                .codDisciplina(idDisciplina)
                .inicioAula(json.getInicioAula())
                .finalAula(json.getFinalAula())
                .duracaoAula(Duration.between(json.getInicioAula(), json.getFinalAula()).toMinutes())
                .dataCriacao(LocalDateTime.now())
                .urlVideo(json.getUrlVideo())
                .nomeAula(json.getNomeAula())
                .descricao(json.getDescricao())
                .build();

        aulaRepository.save(AulaMapper.INSTANCE.aulaToEntity(aula));

        return aula;

    }

    public Object relacionaAluno(String idDisciplina, String idAluno) throws ObjectAlreadyExistsException {

        AlunoDisciplinaPK disciplinaPK = AlunoDisciplinaPK.builder()
                .codAluno(idAluno)
                .codDisciplina(idDisciplina)
                .build();
        AlunoDisciplina alunoDisciplina = AlunoDisciplina.builder()
                .codDisciplina(idDisciplina)
                .codAluno(idAluno)
                .build();

        if(alunoDisciplinaRepository.findById(disciplinaPK).isPresent()){
            throw new  ObjectAlreadyExistsException("Aluno já está registrado nessa disciplina! Id: " + idAluno + ", Tipo: " + Disciplina.class.getName());
        }

        alunoDisciplinaRepository.save(AlunoDisciplinaMapper.INSTANCE.alunoDisciplinaToEntity(alunoDisciplina));

        return alunoDisciplina;
    }
}
