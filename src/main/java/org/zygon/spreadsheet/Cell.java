package org.zygon.spreadsheet;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class Cell {

    public static enum Type {
        VALUE,
        FUNCTION
    }

    public static enum Function {
        SUM,
        MEAN
    }

    public static final class Value {

        // Future: add more data types beyond ints
        private final Integer value;
        private final Function function;
        private final Set<Point> points;

        private Value(Integer value, Function function, Set<Point> points) {
            this.value = value;
            this.function = function;
            this.points = points != null ? Collections.unmodifiableSet(points) : Collections.emptySet();
        }

        public Value(int value) {
            this(value, null, null);
        }

        public Value(Function function, Set<Point> points) {
            this(null, function, points);
        }

        public String getFormula() {
            String formula = null;

            if (function != null) {
                String pointArgs = points.stream()
                        .map(Point::getDisplayString)
                        .collect(Collectors.joining(";"));
                formula = function.name() + "(" + pointArgs + ")";
            }

            return formula;
        }

        public Integer getCalculatedValue(Map<Point, Cell> cellsByPoint) {
            Integer calculatedValue = null;

            if (function != null) {
                IntStream cellIntStream = points.stream()
                        .map(p -> cellsByPoint.get(p))
                        .mapToInt(c -> c.getValue().getCalculatedValue(cellsByPoint));

                switch (function) {
                    case MEAN:
                        Double mean = cellIntStream.average().orElse(0.0);
                        calculatedValue = mean.intValue();
                        break;
                    case SUM:
                        calculatedValue = cellIntStream.sum();
                        break;
                }
            } else {
                calculatedValue = value;
            }

            return calculatedValue;
        }
    }

    private final Type type;
    private final Value value;

    public Cell(Type type, Value value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public Value getValue() {
        return value;
    }

}
