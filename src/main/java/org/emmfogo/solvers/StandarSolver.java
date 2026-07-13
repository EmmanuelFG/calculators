package org.emmfogo.solvers;

import org.mariuszgromada.math.mxparser.Expression;


public class StandarSolver implements ISolver {
    @Override
    public double solveMathemathicalExpression(String operation) {

        Expression e = new Expression(operation);
        return e.calculate();
    }
}
