public class Sphere {
    double radius;

    // add here
    double calcVolume() {
        double v;
        v = (4 * Math.PI * Math.pow(radius, 3)) / 3;
        return v;
    }

    double calcSurface() {
        double s;
        s = 4 * Math.PI * Math.pow(radius, 2);
        return s;
    }
}
