public class RabbitProblem {

    // Fibonacci logic
    public static int rabbitCount(int months) {
        if (months == 0 || months == 1)
            return 1;
        return rabbitCount(months - 1) + rabbitCount(months - 2);
    }

    public static void main(String[] args) {
        int months = 6;
        System.out.println("Rabbit pairs after " + months + " months: " + rabbitCount(months));
    }
}
