package ru.job4j.chess.firuges.black;
// position - start, dest - finish
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Игрок двигает фигуру"
                            + " не по правилам шахмат из %s в %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX()); //TODO maybe
        Cell[] steps = new Cell[size];
        int xPosition = position.getX();
        int yPosition = position.getY();
        int xDest = dest.getX();
        int yDest = dest.getY();
        int deltaX = xDest > xPosition ? 1 : -1;
        int deltaY = yDest > yPosition ? 1 : -1;
        for (int index = 0; index < size; index++) {
            xPosition += deltaX;
            yPosition += deltaY;
            steps[index] = Cell.findBy(xPosition, yPosition);
        }
        return steps;
    }

    public boolean isDiagonal(Cell position, Cell dest) {
        return Math.abs(position.getX() - dest.getX()) == Math.abs(position.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}