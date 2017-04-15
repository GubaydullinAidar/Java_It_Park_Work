public class Rectangle implements Figure {

    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return (a * b);
    }

    @Override
    public double perimetr() {
        return ((a * b) * 2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
