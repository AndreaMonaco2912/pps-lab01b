package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class PieceTest {
    protected Piece piece;
    protected final Pair<Integer, Integer> startingPosition = new Pair<>(2, 2);
    protected final PieceFactory pieceFactory = new PieceFactoryImpl();

    @BeforeEach
    void init(){
        this.piece = createPiece();
    }

    protected abstract Piece createPiece();

    @Test
    void pieceShouldBeAtStartingPosition(){
        assertTrue(piece.isHere(startingPosition));
    }

    @Test
    void piecesInDifferentPositionsShouldNotBeInSamePlace(){
        Piece otherPiece = pieceFactory.createPawn(new Pair<>(0, 0));
        assertFalse(this.piece.isInSamePlace(otherPiece));
    }

    @Test
    void piecesInSamePositionShouldBeInSamePlace(){
        Piece otherPiece = pieceFactory.createPawn(startingPosition);
        assertTrue(this.piece.isInSamePlace(otherPiece));
    }
}
