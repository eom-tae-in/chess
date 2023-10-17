package domain;

import domain.board.Board;
import domain.board.generated.ChessBoardGenerator;
import domain.location.Column;
import domain.location.Location;
import domain.location.Row;
import domain.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String BISHOP = "B";
    private static final String KNIGHT = "N";
    private static final String ROOK = "R";
    private static final String PAWN = "P";

    private Board board;

    @BeforeEach
    void initData() {
        ChessBoardGenerator chessBoardGenerator = new ChessBoardGenerator();
        board = chessBoardGenerator.create();
    }

    @DisplayName("Board를 생성하면 세팅이 완료된 체스판이 만들어지고 이를 반환할 수 있다.")
    @ParameterizedTest
    @MethodSource("keyAndValueProvider")
    void create_chess_board_and_return_chess_board(final Location location, final Team expectedTeam, final String expectedName) {
        //when
        Map<Location, Piece> createdBoard = board.getBoard();

        //then
        assertThat(createdBoard.size()).isEqualTo(32);
        assertThat(createdBoard.get(location).getTeam()).isEqualTo(expectedTeam);
        assertThat(createdBoard.get(location).getName()).isEqualTo(expectedName);
    }

    private static Stream<Arguments> keyAndValueProvider() {
        return Stream.of(
                Arguments.of(Location.of(Row.ONE, Column.A), Team.WHITE, ROOK)
                , Arguments.of(Location.of(Row.ONE, Column.B), Team.WHITE, KNIGHT)
                , Arguments.of(Location.of(Row.ONE, Column.C), Team.WHITE, BISHOP)
                , Arguments.of(Location.of(Row.ONE, Column.D), Team.WHITE, QUEEN)
                , Arguments.of(Location.of(Row.ONE, Column.E), Team.WHITE, KING)
                , Arguments.of(Location.of(Row.ONE, Column.F), Team.WHITE, BISHOP)
                , Arguments.of(Location.of(Row.ONE, Column.G), Team.WHITE, KNIGHT)
                , Arguments.of(Location.of(Row.ONE, Column.H), Team.WHITE, ROOK)
                , Arguments.of(Location.of(Row.TWO, Column.A), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.TWO, Column.B), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.TWO, Column.C), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.TWO, Column.D), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.TWO, Column.E), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.TWO, Column.F), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.TWO, Column.G), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.TWO, Column.H), Team.WHITE, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.A), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.B), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.C), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.D), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.E), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.F), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.G), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.SEVEN, Column.H), Team.BLACK, PAWN)
                , Arguments.of(Location.of(Row.EIGHT, Column.A), Team.BLACK, ROOK)
                , Arguments.of(Location.of(Row.EIGHT, Column.B), Team.BLACK, KNIGHT)
                , Arguments.of(Location.of(Row.EIGHT, Column.C), Team.BLACK, BISHOP)
                , Arguments.of(Location.of(Row.EIGHT, Column.D), Team.BLACK, QUEEN)
                , Arguments.of(Location.of(Row.EIGHT, Column.E), Team.BLACK, KING)
                , Arguments.of(Location.of(Row.EIGHT, Column.F), Team.BLACK, BISHOP)
                , Arguments.of(Location.of(Row.EIGHT, Column.G), Team.BLACK, KNIGHT)
                , Arguments.of(Location.of(Row.EIGHT, Column.H), Team.BLACK, ROOK)
        );
    }
}
