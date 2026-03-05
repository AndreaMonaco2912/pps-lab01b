package it.unibo.pps.e2;

public interface BoardPositionsGenerator {

    /**
     * A class that creates a new position for board Pieces
     *
     * @throws IllegalStateException if there is no more space on the board
     * @return the position of the new piece
     */
    Pair<Integer, Integer> createNewPosition();
}
