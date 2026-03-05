package it.unibo.pps.e2;

import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int SIZE = 5;
    private Pair<Integer, Integer> knight;
    private Pair<Integer, Integer> pawn;
    private Logics logic;

    @BeforeEach
    void init() {
        knight = new Pair<>(2, 2);
        pawn = new Pair<>(2, 4);
        logic = new LogicsImpl(SIZE, pawn, knight);
    }

    @Test
    void knightShouldNotHitUnreachablePosition(){
        assertFalse(logic.hit(pawn.getX(), pawn.getY()));
    }

    @Test
    void knightShouldNeverHitOutOFBound(){
        final List<Pair<Integer, Integer>> impossibleHitSequence = List.of(
                new Pair<>(3, 4),
                new Pair<>(1, 5), //outOfBound
                new Pair<>(0, 3),
                new Pair<>(pawn.getX(), pawn.getY())
        ); // this sequence of moves hit the knight passing over board bounds
        logic.hit(impossibleHitSequence.getFirst().getX(), impossibleHitSequence.getFirst().getY());
        final Pair<Integer, Integer> outOfBoundPosition = impossibleHitSequence.get(1);
        assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(outOfBoundPosition.getX(), outOfBoundPosition.getY()));
    }

    @Test
    void knightShouldHitWithCorrectSequence(){
        final List<Pair<Integer, Integer>> correctHitSequence = List.of(
                new Pair<>(0, 3),
                new Pair<>(pawn.getX(), pawn.getY())
        );
        for(Pair<Integer, Integer> move: correctHitSequence.subList(0, correctHitSequence.size() -1)){
            logic.hit(move.getX(), move.getY());
        }
        assertTrue(logic.hit(correctHitSequence.getLast().getX(), correctHitSequence.getLast().getY()));
    }

    @Test
    void hasKnightInWrongPositionShouldReturnFalse(){
        assertFalse(logic.hasKnight(pawn.getX(), pawn.getY()));
    }

    @Test
    void hasKnightInCorrectPositionShouldReturnTrue(){
        assertTrue(logic.hasKnight((knight.getX()), knight.getY()));
    }
    @Test
    void hasPawnInWrongPositionShouldReturnFalse(){
        assertFalse(logic.hasPawn(knight.getX(), knight.getY()));
    }

    @Test
    void hasPawnInCorrectPositionShouldReturnTrue(){
        assertTrue(logic.hasPawn((pawn.getX()), pawn.getY()));
    }
}
