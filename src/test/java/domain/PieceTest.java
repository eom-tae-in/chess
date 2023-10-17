package domain;

import domain.piece.Piece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String BISHOP = "B";
    private static final String KNIGHT = "N";
    private static final String ROOK = "R";
    private static final String PAWN = "P";

    @DisplayName("기물의 이름을 반환한다.")
    @ParameterizedTest
    @MethodSource("pieceProvider")
    void check_return_piece_name(final Piece piece, final String expectedName) {
        //when
        String name = piece.getName();

        //then
        assertThat(name).isEqualTo(expectedName);
    }

    private static Stream<Arguments> pieceProvider() {
        return Stream.of(
                Arguments.of(new Piece(Team.BLACK, new Name(ROOK)), ROOK)
                , Arguments.of(new Piece(Team.BLACK, new Name(BISHOP)), BISHOP)
                , Arguments.of(new Piece(Team.BLACK, new Name(KNIGHT)), KNIGHT)
                , Arguments.of(new Piece(Team.WHITE, new Name(KING)), KING)
                , Arguments.of(new Piece(Team.WHITE, new Name(QUEEN)), QUEEN)
        );
    }

    @DisplayName("기물이 검은색일 경우 true를 반환하고 아닌 경우 false를 반환한다.")
    @ParameterizedTest
    @MethodSource("pieceAndTeamInfoProvider")
    void check_piece_is_black_return_turn_if_not_return_false(final Piece piece, final boolean expected) {
        //when
        boolean result = piece.isBlack();

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> pieceAndTeamInfoProvider() {
        return Stream.of(
                Arguments.of(new Piece(Team.BLACK, new Name(ROOK)), true)
                ,Arguments.of(new Piece(Team.BLACK, new Name(BISHOP)), true)
                ,Arguments.of(new Piece(Team.BLACK, new Name(KNIGHT)), true)
                ,Arguments.of(new Piece(Team.WHITE, new Name(QUEEN)), false)
                ,Arguments.of(new Piece(Team.WHITE, new Name(KING)), false)
        );
    }
}
