public class Calculation {
    int number;

    // add here
    void printSquare() {
        System.out.println("Square : " + (number*number));
    }

    void printFactorial() {
        System.out.println("Factorial : " + factorial(number));
    }

    int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
