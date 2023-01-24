package com.amirkenesbay.controller;

import com.amirkenesbay.entity.Scoreboard;
import com.amirkenesbay.service.ScoreboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/generateCode")
@RequiredArgsConstructor
public class ScoreboardController {
    private final ScoreboardService scoreboardService;

    @PostMapping
    public ResponseEntity<Scoreboard> createScoreboardCode() {
        return new ResponseEntity<>(scoreboardService.generateNextCode(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Scoreboard> getLastScoreboardCode() {
        return new ResponseEntity<>(scoreboardService.getLastGeneratedCode(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Scoreboard getLastScoreboardCode(@PathVariable Long id) {
        return scoreboardService.getLastGeneratedCodeId(id);
    }
}
