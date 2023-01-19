package com.amirkenesbay.controller;

import com.amirkenesbay.entity.Scoreboard;
import com.amirkenesbay.service.ScoreboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/generateCode")
@RequiredArgsConstructor
public class ScoreboardController {
    private final ScoreboardService scoreboardService;

    @PostMapping
    public Scoreboard createScoreboardCode() {
        return scoreboardService.generateNextCode();
    }

    @GetMapping
    public Scoreboard getLastScoreboardCode() {
        return scoreboardService.getLastGeneratedCode();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Scoreboard getLastScoreboardCode(@PathVariable Long id) {
        return scoreboardService.getLastGeneratedCodeId(id);
    }
}
