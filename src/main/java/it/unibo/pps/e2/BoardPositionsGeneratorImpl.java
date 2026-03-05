package it.unibo.pps.e2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BoardPositionsGeneratorImpl implements BoardPositionsGenerator {

    private final Set<Pair<Integer, Integer>> allPositions = new HashSet<>();
    private final Random random = new Random();
    private final int dimension;

    public BoardPositionsGeneratorImpl(int size) { // The board is a square
        this.dimension = size;
    }

    @Override
    public Pair<Integer, Integer> createNewPosition() {
        if (this.isFull()) {
            throw new IllegalStateException();
        }
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(dimension), this.random.nextInt(dimension));
        return allPositions.add(pos) ? pos : createNewPosition();
    }

    private boolean isFull() {
        return allPositions.size() >= dimension * dimension;
    }

}
