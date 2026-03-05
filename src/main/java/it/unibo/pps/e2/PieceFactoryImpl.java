package it.unibo.pps.e2;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public Piece createKnight(Pair<Integer, Integer> startingPosition) {
        return new PieceImpl(startingPosition, (startPosition, nextPosition) -> {
            int x = nextPosition.getX()-startPosition.getX();
            int y = nextPosition.getY()-startPosition.getY();
            return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
        });
    }

    @Override
    public Piece createPawn(Pair<Integer, Integer> startingPosition) {
        return new PieceImpl(startingPosition, (pos1, pos2) -> false);
    }
}
