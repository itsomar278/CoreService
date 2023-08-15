package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.SeasonEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonEpisodeRepository extends JpaRepository<SeasonEpisode, Integer> {
}
