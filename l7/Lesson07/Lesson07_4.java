public class Lesson07_4 {
    public static void main(String[] args) {
        double radius = Double.parseDouble(args[0]);

        // add here
        Sphere calc = new Sphere();
        calc.radius = radius;
        System.out.println("球の体積V : " + calc.calcVolume());
        System.out.println("球の表面積S : " + calc.calcSurface());
    }
}
