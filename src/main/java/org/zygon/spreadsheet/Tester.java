package org.zygon.spreadsheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Point point1 = new Point(1, 1);
        Point point2a = new Point(2, 2);
        Point point2b = new Point(2, 3);
        Point sumValuePoint = new Point(3, 3);
        Point sumValueTotalPoint = new Point(4, 4);

        Cell.Value value1 = new Cell.Value(10);
        Cell.Value value2a = new Cell.Value(2);
        Cell.Value value2b = new Cell.Value(2);

        Set<Point> valuePoints = new HashSet<>();
        valuePoints.add(point1);
        valuePoints.add(sumValuePoint);
        Cell.Value valueSumTotal = new Cell.Value(Cell.Function.SUM, valuePoints);

        Set<Point> value2Points = new HashSet<>();
        value2Points.add(point2a);
        value2Points.add(point2b);
        Cell.Value valueSum2 = new Cell.Value(Cell.Function.SUM, value2Points);

        Cell cell1 = new Cell(Cell.Type.VALUE, value1);
        Cell cell2a = new Cell(Cell.Type.VALUE, value2a);
        Cell cell2b = new Cell(Cell.Type.VALUE, value2b);
        Cell valueSumCell = new Cell(Cell.Type.VALUE, valueSum2);
        Cell valueTotalCell = new Cell(Cell.Type.VALUE, valueSumTotal);

        Map<Point, Cell> cellsByPoint = new HashMap<>();
        cellsByPoint.put(point1, cell1);
        cellsByPoint.put(point2a, cell2a);
        cellsByPoint.put(point2b, cell2b);
        cellsByPoint.put(sumValuePoint, valueSumCell);
        cellsByPoint.put(sumValueTotalPoint, valueTotalCell);

        View view1 = new View(5, 5, cellsByPoint);

        List<CellRender> cellRenders = new ArrayList<>();
        cellRenders.add(new CoordCellRender());
        cellRenders.add(new CellValueRender());
        cellRenders.add(new CellFormulaRender());

        ViewRender viewRender = new ConsoleViewRender();

        cellRenders.forEach(cr -> {
            viewRender.render(view1, cr);
            System.out.println("-------------------------------");
        });
    }

}
