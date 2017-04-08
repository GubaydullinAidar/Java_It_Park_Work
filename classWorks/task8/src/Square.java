/**
 * Created by Student9 on 08.04.2017.
 */
public class Square implements Figure {

    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return (a * a);
    }

    @Override
    public double perimetr() {
        return (4 * a);
    }
}
