package com.amirkenesbay.repository;

import com.amirkenesbay.entity.Scoreboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {
}
