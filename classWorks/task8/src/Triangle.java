/**
 * Created by Student9 on 08.04.2017.
 */
public class Triangle implements Figure {

    private double a, b, c, h;

    public Triangle(double a, double b, double c, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public double area() {
        return a * h;
    }

    @Override
    public double perimetr() {
        return (a + b + c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", h=" + h +
                '}';
    }
}
