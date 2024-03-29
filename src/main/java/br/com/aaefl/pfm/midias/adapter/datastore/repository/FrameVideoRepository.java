package br.com.aaefl.pfm.midias.adapter.datastore.repository;

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
public interface FrameVideoRepository extends JpaRepository<VideoFramesEntity, VideoFramesPK> {

    @Query("select u.codFrame from VideoFramesEntity u where u.codVideo = :codVideo")
    List<String> buscaIdFramePorVideo(@Param("codVideo") String codVideo);

}
