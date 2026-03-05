package it.unibo.pps.e2;

public interface Logics{
    
    /**
     * attempt to move Knight on position row,col, if possible
     * 
     * @param row position x
     * @param col position y
     * @throws IndexOutOfBoundsException if number out of the board are given
     * @return whether the pawn has been hit 
     */
    boolean hit(int row, int col);
    
    /**
     * @param row position x
     * @param col position y
     * @return whether position row,col has the knight
     */
    boolean hasKnight(int row, int col);
    
    /**
     * @param row position x
     * @param col position y
     * @return whether position row,col has the pawn
     */
    boolean hasPawn(int row, int col);
}
