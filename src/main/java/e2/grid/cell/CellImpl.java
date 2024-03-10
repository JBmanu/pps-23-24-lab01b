package e2.grid.cell;

import e1.piece.position.Position;

public class CellImpl implements Cell {
    private final Position position;
    private int countMines;
    private boolean haveBeenComputeMines;
    boolean isMine;

    public CellImpl(final Position position) {
        this.position = position;
        this.isMine = false;
        this.countMines = 0;
        this.haveBeenComputeMines = false;
    }


    @Override
    public void skillsLikeMine() {
        this.isMine = true;
    }

    @Override
    public boolean isMine() {
        return this.isMine;
    }

    @Override
    public int minesAround() {
        return this.countMines;
    }

    @Override
    public void setMinesAround(final int count) {
        this.countMines = count;
        this.haveBeenComputeMines = true;
    }

    @Override
    public boolean haveBeenComputeMines() {
        return this.haveBeenComputeMines;
    }

    @Override
    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }

}
