package org.zygon.spreadsheet;

import java.util.Collections;
import java.util.Map;

/**
 *
 */
public class View {

    private final int maxX;
    private final int maxY;
    private final Map<Point, Cell> values;

    public View(int maxX, int maxY, Map<Point, Cell> values) {
        //need to handle point out of bounds. could calculate
        this.maxX = maxX;
        this.maxY = maxY;
        this.values = values != null
                ? Collections.unmodifiableMap(values) : Collections.emptyMap();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public Map<Point, Cell> getValues() {
        return values;
    }

}
