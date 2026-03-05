package it.unibo.pps.e2;

public class PieceImpl implements Piece {
    private Pair<Integer, Integer> position;
    private final Movement movement;

    public PieceImpl(Pair<Integer, Integer> startingPosition, Movement movement) {
        this.position = startingPosition;
        this.movement = movement;
    }

    @Override
    public boolean moveHere(Pair<Integer, Integer> newPosition) {
        if(movement.canMoveHere(this.position, newPosition)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public boolean isHere(Pair<Integer, Integer> position) {
        return this.position.equals(position);
    }

    @Override
    public boolean isInSamePlace(Piece otherPiece) {
        return otherPiece.isHere(this.position);
    }
}
