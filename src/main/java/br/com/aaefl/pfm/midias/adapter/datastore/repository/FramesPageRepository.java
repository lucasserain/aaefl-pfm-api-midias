package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.FramesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FramesPageRepository extends PagingAndSortingRepository<FramesEntity, String> {

    @Query("select u from FramesEntity u where u.idFrame = :idFrame")
    List<FramesEntity> findAllByIdFrame(@Param("idFrame")String idFrame, Pageable pageable);
}
