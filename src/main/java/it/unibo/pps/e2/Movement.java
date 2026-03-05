package it.unibo.pps.e2;

public interface Movement {

    /**
     * function that tell if the moving entity can reach selected position
     * @param startingPosition position where the entity is
     * @param newPosition position that the entity needs to reach
     * @return true if the move is possible
     */
    boolean canMoveHere(Pair<Integer, Integer> startingPosition, Pair<Integer, Integer> newPosition);
}
