import java.util.Arrays;

public class MinMaxCalculation {
    double[] calculate(double[] numbers) {
        // pass by reference and i do not want to change the origin variable
        // -> make copy
        double[] sorted_arr = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted_arr);
        double[] result = { sorted_arr[0], sorted_arr[numbers.length - 1] };
        return result;
    }
}
