package org.zygon.spreadsheet;

import java.util.Map;

/**
 * Renders the values or calculated values.
 */
public class CellValueRender implements CellRender {

    @Override
    public String renderCell(Point point, Cell cell, Map<Point, Cell> cellsByPoint) {
        Cell.Value value = cell.getValue();

        return String.valueOf(value.getCalculatedValue(cellsByPoint));
    }

}
