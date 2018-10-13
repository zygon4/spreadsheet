package org.zygon.spreadsheet;

import java.util.Map;

/**
 *
 */
public class CoordCellRender implements CellRender {

    @Override
    public String renderCell(Point point, Cell cell, Map<Point, Cell> cellsByPoint) {
        return point.getX() + "," + point.gety();
    }

}
