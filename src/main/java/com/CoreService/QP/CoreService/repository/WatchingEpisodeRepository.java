package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.WatchingEpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchingEpisodeRepository extends JpaRepository<WatchingEpisodeEntity, Integer> {
}
