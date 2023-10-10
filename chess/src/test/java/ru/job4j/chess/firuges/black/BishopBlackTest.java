package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    public void whenCreateBishopBlackC8() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell result = bishopBlack.position();
        Cell expected = Cell.C8;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenCopyBishopBlackFromF8ToH6() {
        Figure bishopBlack = new BishopBlack(Cell.F8);
        Cell result = bishopBlack.copy(Cell.H6).position();
        Cell expected = Cell.H6;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMoveFromC1ToG5ThenReturmArrayD2E3F4G5() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMoveFromC1ToG5ThenDiagonalTrue() {
        assertThat(new BishopBlack(Cell.C1).isDiagonal(Cell.C1, Cell.G5)).isTrue();
    }

    @Test
    public void when() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exeption = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.C5));
        assertThat(exeption.getMessage()).isEqualTo("Could not move by diagonal from C1 to C5");
    }
}