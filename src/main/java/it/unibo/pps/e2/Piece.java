package it.unibo.pps.e2;

public interface Piece {
    /**
     * change the position of the piece
     *
     * @param newPosition the position where we want the piece to go.
     * @return True if the move con happen.
     */
    boolean moveHere(Pair<Integer, Integer> newPosition);

    /**
     * @return whether the position has the piece.
     */
    boolean isHere(Pair<Integer, Integer> position);

    /**
     *
     * @param otherPiece that should be in same position of this
     * @return true if this piece and the other are in the same place
     */
    boolean isInSamePlace(Piece otherPiece);
}
