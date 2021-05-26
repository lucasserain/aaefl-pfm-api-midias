package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioFrameAulaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioFrameAulaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UsuarioFrameAulaRepository extends JpaRepository<UsuarioFrameAulaEntity, UsuarioFrameAulaPK> {

    @Query("select u from UsuarioFrameAulaEntity u where u.codAula = :idAula")
    List<UsuarioFrameAulaEntity> buscaPorAula(@Param("idAula") String idAula);

    @Query("select u from UsuarioFrameAulaEntity u where u.codAula = :idAula and u.codAluno = :idAluno")
    List<UsuarioFrameAulaEntity> buscaPorAulaAluno(@Param("idAula") String idAula, @Param("idAluno") String idAluno);
}
