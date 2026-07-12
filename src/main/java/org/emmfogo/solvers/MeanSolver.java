package org.emmfogo.solvers;

import java.util.List;

public class MeanSolver implements ISolver {
    @Override
    public float solveMathemathicalExpression(String operation) {
        List<String> numbers = List.of((operation.split(" ")));
        float mean = 0;
        for (String number : numbers) {
            mean += Float.parseFloat(number);
        }
        return mean / numbers.size();
    }
}
