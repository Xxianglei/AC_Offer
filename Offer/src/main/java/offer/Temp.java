package offer;

public class Temp {
    private static int N = 0;
    private static int sum = 0;
    public Temp() {
        ++N;
        sum += N;
    }
    public static void ReSet() {
        N = 0;
        sum = 0;
    }
    public static int Get() {
        return sum;
    }

}