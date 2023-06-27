public class Lesson07_3 {
    public static void main(String[] args){
        Calculation c = new Calculation();
        c.number = Integer.parseInt(args[0]);
        c.printSquare();
        c.printFactorial();
    }
}