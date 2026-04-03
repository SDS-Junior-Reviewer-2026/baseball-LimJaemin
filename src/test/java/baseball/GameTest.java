package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            org.junit.jupiter.api.Assertions.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    @Test
    public void returnSolvedResultIfMatchedNumber() {
        game.question = "123";
        GuessResult result = game.guess("123");

        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(true);
        assertThat(result.getStrikes()).isEqualTo(3);
        assertThat(result.getBalls()).isEqualTo(0);
    }

    @Test
    public void returnSolvedResultIfUnMatchedNumber() {
        game.question = "123";
        GuessResult result = game.guess("456");

        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(false);
        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getStrikes()).isEqualTo(0);
    }

    @Test
    public void 스트라이크만_있을_경우_1_strike_0_ball() {

    }

    @Test
    public void 볼만_있을_경우_0_strike_1_ball() {

    }

    @Test
    public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {

    }
}
