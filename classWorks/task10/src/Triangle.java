/**
 * Created by Student9 on 15.04.2017.
 */
public class Triangle {

    private double a, b, h;

    public Triangle(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", h=" + h +
                '}';
    }
}
