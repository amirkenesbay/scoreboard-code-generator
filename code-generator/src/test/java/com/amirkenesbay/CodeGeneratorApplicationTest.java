package com.amirkenesbay;

import com.amirkenesbay.entity.Scoreboard;
import com.amirkenesbay.service.ScoreboardServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CodeGeneratorApplicationTest {
    private final Scoreboard scoreboard = new Scoreboard();

    @Autowired
    private ScoreboardServiceImpl scoreboardService;

    @Test
    public void shouldReturnNumberOneInTheEndOfCharacter() {
        scoreboard.setCodeName("a0a0");
        String scoreboardCode = scoreboardService.getGenerateCode(scoreboard);
        Assertions.assertEquals(scoreboardCode, "a0a1");
    }

    @Test
    public void shouldReturnCharacterBInThePenultimateCharacterAndZeroInTheEndOfTheCharacter() {
        scoreboard.setCodeName("a0a9");
        String scoreboardCode = scoreboardService.getGenerateCode(scoreboard);
        Assertions.assertEquals(scoreboardCode, "a0b0");
    }

    @Test
    public void shouldAddTwoElementsInTheEndOfCharacterAndAllShouldStartFromTheBeginningCharacters() {
        scoreboard.setCodeName("z9z9");
        String scoreboardCode = scoreboardService.getGenerateCode(scoreboard);
        Assertions.assertEquals(scoreboardCode, "a0a0a0");
    }

    @Test
    public void shouldAddTwoElementsInTheEndOfCharacterAndAllShouldStartFromTheBeginningCharacters2() {
        scoreboard.setCodeName("z9z9z9");
        String scoreboardCode = scoreboardService.getGenerateCode(scoreboard);
        Assertions.assertEquals(scoreboardCode, "a0a0a0a0");
    }

    @Test
    public void shouldReturnZWithZeroAndTwoLastCharacterShouldStartFromTheBeginningCharacters() {
        scoreboard.setCodeName("a0a0y9z9");
        String scoreboardCode = scoreboardService.getGenerateCode(scoreboard);
        Assertions.assertEquals(scoreboardCode, "a0a0z0a0");
    }

    @Test
    public void testCode4() {
        scoreboard.setCodeName("a0a0a9a0a0z9");
        String stringNextCode = scoreboardService.getGenerateCode(scoreboard);
        Assertions.assertEquals(stringNextCode, "a0a0a9a0a1a0");
    }
}
