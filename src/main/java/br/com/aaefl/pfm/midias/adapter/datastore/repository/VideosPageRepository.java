package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioVideoAulaEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuarioVideoAulaPK;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuariosEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.entity.VideoFramesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface VideosPageRepository extends PagingAndSortingRepository<UsuarioVideoAulaEntity, UsuarioVideoAulaPK> {

    @Query("select u.codVideo from UsuarioVideoAulaEntity u where u.codAula = :idAula")
    List<String> buscaVideoPorAula(@Param("idAula") String idAula);

    @Query("select u.codVideo from UsuarioVideoAulaEntity u where u.codAula = :idAula and u.codAluno = :idAluno")
    List<String> buscaVideoPorAulaAluno(@Param("idAula") String idAula, @Param("idAluno") String idAluno);

    @Query("select u from UsuarioVideoAulaEntity u where u.codAula = :idAula")
    List<UsuarioVideoAulaEntity> buscaAlunosPorAula(@Param("idAula") String idAula);
}
