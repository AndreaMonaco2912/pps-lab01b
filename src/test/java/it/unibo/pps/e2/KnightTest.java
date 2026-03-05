package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest extends PieceTest{

    @Test
    void shouldNotMoveInUnreachablePositions(){
        assertFalse(piece.moveHere(new Pair<>(2, 4)));
    }

    @Test
    void shouldMoveInReachablePositions(){
        assertTrue(piece.moveHere(new Pair<>(3, 4)));
    }

    @Test
    void moveShouldUpdatePositon(){
        Pair<Integer, Integer> nextPosition = new Pair<>(3, 4);
        piece.moveHere(nextPosition);
        assertTrue(piece.isHere(nextPosition));
    }

    @Override
    protected Piece createPiece() {
        return pieceFactory.createKnight(startingPosition);
    }
}
