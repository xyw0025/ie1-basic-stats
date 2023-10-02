import java.util.Arrays;

public class MinMaxCalculation {
    public static void main(String[] args) {
        double[] numbers = convert2DoubleArray(args);
        double[] results = calculate(numbers);
        System.out.println("Min: " + results[0]);
        System.out.println("Max: " + results[1]);
    }

    private static double[] calculate(double[] numbers) {
        // pass by reference and i do not want to change the origin variable
        // -> make copy
        double[] sorted_arr = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted_arr);
        double[] result = { sorted_arr[0], sorted_arr[numbers.length - 1] };
        return result;
    }

    private static double[] convert2DoubleArray(String[] arr) {
        return Arrays.stream(arr).mapToDouble(Double::parseDouble).toArray();
    }
}
