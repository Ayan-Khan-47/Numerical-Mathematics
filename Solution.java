/*
This class can be used in any other numerical method for solving functions at given value.

To use this you need to import javaluator from fathzer in your project.
*/

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

public class Solution {
    static Double SOLVE(String ex, Double set) {
        DoubleEvaluator eval = new DoubleEvaluator();
        StaticVariableSet<Double> variables = new StaticVariableSet<>();
        variables.set("x", set);
        return eval.evaluate(ex, variables);
    }
}
