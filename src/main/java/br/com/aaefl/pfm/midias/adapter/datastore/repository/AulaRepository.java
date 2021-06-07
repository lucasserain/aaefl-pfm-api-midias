package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.AulaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AulaRepository extends JpaRepository<AulaEntity, String> {

    @Query("select u from AulaEntity u where u.codDisciplina = :idDisciplina")
    List<AulaEntity> findAulasByIdDisciplina(@Param("idDisciplina") String idDisciplina);
}
