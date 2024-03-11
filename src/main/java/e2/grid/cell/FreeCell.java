package e2.grid.cell;

import e1.piece.position.Position;

public class FreeCell implements Cell {
    private final Position position;
    private int countMines;
    private boolean isShowCell;
    boolean isMine;

    public FreeCell(final Position position) {
        this.position = position;
        this.isMine = false;
        this.countMines = 0;
        this.isShowCell = false;
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
    public void setMinesAround(final int mines) {
        this.countMines = mines;
    }

    @Override
    public int minesAround() {
        return this.countMines;
    }

    @Override
    public void showCell() {
        this.isShowCell = true;
    }

    @Override
    public boolean isShowCell() {
        return this.isShowCell;
    }

    @Override
    public boolean equalsPosition(final Position position) {
        return this.position.equals(position);
    }

    @Override
    public Position position() {
        return this.position;
    }

}
