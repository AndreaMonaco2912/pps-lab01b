package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardPositionGeneratorTest
{
    private static final int SIZE = 5;
    private BoardPositionsGenerator positionsGenerator;

    @BeforeEach
    void init(){
        positionsGenerator = new BoardPositionsGeneratorImpl(SIZE);
    }

    @Test
    void positionsGeneratorShouldGivePositionInsideTheBoard(){
        Pair<Integer, Integer> newPosition = positionsGenerator.createNewPosition();
        assertTrue(isInsideTheBoard(newPosition));
    }

    private static boolean isInsideTheBoard(Pair<Integer, Integer> position) {
        return 0 <= position.getX() && position.getX() < SIZE && 0 <= position.getY() && position.getY() < SIZE;
    }

    @Test
    void insertTooManyPiecesShouldThrowException(){
        for(int i=0; i< SIZE * SIZE; i++){
            positionsGenerator.createNewPosition();
        }
        assertThrows(IllegalStateException.class, () -> positionsGenerator.createNewPosition());
    }
}
