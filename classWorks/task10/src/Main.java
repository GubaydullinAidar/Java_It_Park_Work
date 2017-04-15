public class Main {

    public static void main(String[] args) {
        Object triangle = new Triangle(1, 2, 3);
        Object square = new Square(3);
        Object rectangle = new Rectangle(2, 4);

        Object figures[] = {triangle, square, rectangle};

        FigureToFile.figureFile(figures);
    }
}
