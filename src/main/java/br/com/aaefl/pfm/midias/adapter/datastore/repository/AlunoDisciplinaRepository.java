package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.AlunoDisciplinaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.AlunoDisciplinaPK;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.VideoFramesEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.VideoFramesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplinaEntity, AlunoDisciplinaPK> {

    @Query("select u.codAluno from AlunoDisciplinaEntity u where u.codDisciplina = :codDisciplina")
    List<String> buscaUsuariosPorDisciplina(@Param("codDisciplina") String codDisciplina);

    @Query("select u.codDisciplina from AlunoDisciplinaEntity u where u.codAluno = :codAluno")
    List<String> buscaDisciplinasPorUsuario(@Param("codAluno") String codAluno);
}
