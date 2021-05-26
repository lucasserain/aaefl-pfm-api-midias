package br.com.aaefl.pfm.midias.adapter.datastore.repository;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.FramesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FramesRepository extends JpaRepository<FramesEntity, String> {
}
