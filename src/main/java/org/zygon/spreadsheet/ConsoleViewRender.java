package org.zygon.spreadsheet;

import java.util.Map;

/**
 *
 */
public class ConsoleViewRender implements ViewRender {

    @Override
    public String render(View view, CellRender cellRender) {

        Map<Point, Cell> values = view.getValues();

        for (int y = 0; y < view.getMaxY(); y++) {
            for (int x = 0; x < view.getMaxX(); x++) {
                Point lookupPoint = new Point(x, y);
                Cell cell = values.get(lookupPoint);
                String renderedCell = null;
                if (cell != null) {
                    renderedCell = cellRender.renderCell(lookupPoint, cell, values);
                } else {
                    renderedCell = "   ";
                }
                System.out.print(renderedCell + "|");
            }

            System.out.println();
        }

        return "";
    }

}
