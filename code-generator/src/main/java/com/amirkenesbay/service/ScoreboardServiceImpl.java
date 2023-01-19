package com.amirkenesbay.service;

import com.amirkenesbay.entity.Scoreboard;
import com.amirkenesbay.exceptions.ScoreboardCodeNotFoundException;
import com.amirkenesbay.repository.ScoreboardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j
public class ScoreboardServiceImpl implements ScoreboardService {

    private final ScoreboardRepository scoreboardRepository;

    @Override
    public Scoreboard generateNextCode() {
        Scoreboard lastScoreboardCode = getLastGeneratedCode();
        String generatedCode = getGenerateCode(lastScoreboardCode);
        Scoreboard newScoreboardCode = new Scoreboard();
        newScoreboardCode.setCodeName(generatedCode);
        scoreboardRepository.save(newScoreboardCode);
        return newScoreboardCode;
    }

    @Override
    public Scoreboard getLastGeneratedCode() {
        List<Scoreboard> scoreboardList = scoreboardRepository.findAll();
        log.debug(scoreboardList);
        return scoreboardList.get(scoreboardList.size() - 1);
    }

    @Override
    public Scoreboard getLastGeneratedCodeId(Long id) {
        return scoreboardRepository.findById(id).orElseThrow(
                () -> new ScoreboardCodeNotFoundException("Scoreboard code with id " + id + " not found"));
    }

    /**
     * Get generated code for scoreboard
     *
     * @param scoreboard
     */
    public String getGenerateCode(Scoreboard scoreboard) {
        String code = scoreboard.getCodeName();
        int codePosition = code.length() - 2;
        while (codePosition >= 0) {
            if (code.charAt(codePosition + 1) == '9' && code.charAt(codePosition) == 'z') {
                codePosition -= 2;
            } else {
                break;
            }
        }
        StringBuilder newCharsCode;
        int position;
        if (codePosition == -2) {
            newCharsCode = new StringBuilder();
            position = codePosition;
            while (position < code.length()) {
                newCharsCode.append('a');
                newCharsCode.append('0');
                position += 2;
            }
        } else {
            newCharsCode = new StringBuilder(code);
            position = codePosition + 2;
            while (position < code.length()) {
                newCharsCode.setCharAt(position, 'a');
                newCharsCode.setCharAt(position + 1, '0');
                position += 2;
            }
            if (code.charAt(codePosition + 1) != '9') {
                codePosition++;
            } else {
                newCharsCode.setCharAt(codePosition + 1, '0');
            }
            newCharsCode.setCharAt(codePosition, (char) (newCharsCode.charAt(codePosition) + 1));
        }
        return newCharsCode.toString();
    }
}
