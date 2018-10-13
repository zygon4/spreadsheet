package org.zygon.spreadsheet;

import java.util.Map;

/**
 *
 */
public interface CellRender {

    String renderCell(Point point, Cell cell, Map<Point, Cell> cellsByPoint);
}
