public class Main {



    public static void main(String[] args) {

        System.out.println("Hello");
        
        Square square1 = new Square(4);
        Square square2 = new Square(5);
        Rectangle rectangle1 = new Rectangle(3, 6);
        Rectangle rectangle2 = new Rectangle(2, 9);
        Triangle triangle1 = new Triangle(1, 2, 3, 2);
        Triangle triangle2 = new Triangle(2, 1, 4, 3);

        Figure arrfigurs[] = {square1, square2, rectangle1,
        rectangle2, triangle1, triangle2};

        double tmpPer = 0;
        double tmpArea = 0;

        for (int i = 0; i < arrfigurs.length; i++) {
            if (arrfigurs[i] instanceof Figure) {
                tmpPer = arrfigurs[i].perimetr();
                tmpArea = arrfigurs[i].area();
            } else {
                arrfigurs[i] = null;
            }

            for (int j = i + 1; j < arrfigurs.length; j++) {
                if (tmpPer == arrfigurs[j].perimetr() || tmpArea == arrfigurs[j].area()){
                    arrfigurs[i] = null;
                }
            }
        }

        for (int k = 0; k < arrfigurs.length; k++) {
            if (arrfigurs[k] != null) {
                System.out.println(arrfigurs[k].toString() + " ");
            }
        }
     }
}

