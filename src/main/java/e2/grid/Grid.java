package e2.grid;

import e1.piece.position.Position;

import java.util.List;

public interface Grid {

    void setMineIn(final Position position);

    boolean isMine(final Position position);

    int countMinesIn(final Position position);

    void showCell(final Position position);

    boolean isShowCell(final Position position);

    boolean hasWin();

    Position generateEmptyCell();

    int size();

    int totalMines();

    List<Position> freeCellsPositions();
}
