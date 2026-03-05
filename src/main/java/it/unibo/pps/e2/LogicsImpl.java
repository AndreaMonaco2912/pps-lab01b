package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Piece pawn;
	private final Piece knight;
	private final BoardPositionsGenerator positionsGenerator;
    private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
		this.positionsGenerator = new BoardPositionsGeneratorImpl(size);
        PieceFactory pieceFactory = new PieceFactoryImpl();
        this.pawn = pieceFactory.createPawn(this.positionsGenerator.createNewPosition());
        this.knight = pieceFactory.createKnight(this.positionsGenerator.createNewPosition());
    }

	LogicsImpl(int size, Piece pawn, Piece knight){
		this.size = size;
		this.positionsGenerator = new BoardPositionsGeneratorImpl(size);
		this.pawn = pawn;
		this.knight = knight;
	}
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		if (knight.moveHere(new Pair<>(row, col))) {
			return this.pawn.isInSamePlace(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.isHere(new Pair<>(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.isHere(new Pair<>(row, col));
	}
}
