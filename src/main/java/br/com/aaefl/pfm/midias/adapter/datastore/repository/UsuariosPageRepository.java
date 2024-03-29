package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuariosEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UsuariosPageRepository extends PagingAndSortingRepository<UsuariosEntity, String> {

    @Query("select u from UsuariosEntity u where u.tipoUsuario = :tipo")
    List<UsuariosEntity> findAllAlunos(Pageable pageable, @Param("tipo")int tipo);


    @Query("select u from UsuariosEntity u where u.tipoUsuario = :tipo and u.nome LIKE %:nome%")
    List<UsuariosEntity> findAlunosName(@Param("nome") String nome, Pageable paginacao,@Param("tipo") int tipo);
}
