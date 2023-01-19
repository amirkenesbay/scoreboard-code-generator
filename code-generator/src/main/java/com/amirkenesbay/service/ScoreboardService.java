package com.amirkenesbay.service;

import com.amirkenesbay.entity.Scoreboard;

public interface ScoreboardService {
    Scoreboard generateNextCode();

    Scoreboard getLastGeneratedCode();

    Scoreboard getLastGeneratedCodeId(Long id);
}
