package org.zygon.spreadsheet;

import java.util.Map;

/**
 *
 */
public class CellFormulaRender implements CellRender {

    @Override
    public String renderCell(Point point, Cell cell, Map<Point, Cell> cellsByPoint) {
        Cell.Value value = cell.getValue();
        String formula = value.getFormula();
        return formula != null ? formula : "";
    }
}
