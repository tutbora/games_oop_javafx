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
        for (int index = 0; index < size; index++) {
            if (xPosition > xDest && yPosition > yDest) {
                steps[index] = Cell.findBy(--xPosition, --yPosition);
            }
            if (xPosition < xDest && yPosition < yDest) {
                steps[index] = Cell.findBy(++xPosition, ++yPosition);
            }
            if (xPosition > xDest && yPosition < yDest) {
                steps[index] = Cell.findBy(--xPosition, ++yPosition);
            }
            if (xPosition < xDest && yPosition > yDest) {
                steps[index] = Cell.findBy(++xPosition, --yPosition);
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell position, Cell dest) {
        boolean diag = false;
        int size = Math.abs(position.getX() - dest.getX()); //TODO maybe
        int xPosition = position.getX();
        int yPosition = position.getY();
        int xDest = dest.getX();
        int yDest = dest.getY();
            if (xPosition > xDest && yPosition > yDest) {
                for (int i = 0; i < size; i++) {
                    xPosition--;
                    yPosition--;
                }
                diag = Cell.findBy(xPosition, yPosition).equals(dest);
            }
            if (xPosition < xDest && yPosition < yDest) {
                for (int i = 0; i < size; i++) {
                    xPosition++;
                    yPosition++;
                }
                diag = Cell.findBy(xPosition, yPosition).equals(dest);
            }
            if (xPosition > xDest && yPosition < yDest) {
                for (int i = 0; i < size; i++) {
                    xPosition--;
                    yPosition++;
                }
                diag = Cell.findBy(xPosition, yPosition).equals(dest);
            }
            if (xPosition < xDest && yPosition > yDest) {
                for (int i = 0; i < size; i++) {
                    xPosition++;
                    yPosition--;
                }
                diag = Cell.findBy(xPosition, yPosition).equals(dest);
            }
        return diag;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}