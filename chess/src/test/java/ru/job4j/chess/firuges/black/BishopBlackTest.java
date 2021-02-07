package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell checkPosition = bishopBlack.position();
        assertThat(checkPosition, is(C1));
    }

    @Test
    public void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Figure checkCopy = bishopBlack.copy(C1);
        assertThat(checkCopy.position(), is(C1));
    }

    @Test
    public void whenWayToRightUp() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] wayCheck = bishopBlack.way(G5);
        Cell[] wayExp = {D2, E3, F4, G5};
        assertThat(wayCheck, is(wayExp));
    }

    @Test
    public void whenWayToRightDown() {
        BishopBlack bishopBlack = new BishopBlack(C8);
        Cell[] wayCheck = bishopBlack.way(H3);
        Cell[] wayExp = {D7, E6, F5, G4, H3};
        assertThat(wayCheck, is(wayExp));
    }

    @Test
    public void whenWayToLeftUp() {
        BishopBlack bishopBlack = new BishopBlack(D3);
        Cell[] wayCheck = bishopBlack.way(B5);
        Cell[] wayExp = {C4, B5};
        assertThat(wayCheck, is(wayExp));
    }

    @Test
    public void whenWayToLeftDown() {
        BishopBlack bishopBlack = new BishopBlack(G6);
        Cell[] wayCheck = bishopBlack.way(C2);
        Cell[] wayExp = {F5, E4, D3, C2};
        assertThat(wayCheck, is(wayExp));
    }
}