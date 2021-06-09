package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.DisciplinaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.VideosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, String> {

    @Query("select u from DisciplinaEntity u where u.codProfessor = :codProfessor")
    List<DisciplinaEntity> buscaDisciplinasPorProfessor(@Param("codProfessor") String codProfessor);
}
