package it.unibo.pps.e2;

public interface PieceFactory {

    Piece createKnight(Pair<Integer, Integer> startingPosition);

    Piece createPawn(Pair<Integer, Integer> startingPosition);
}
