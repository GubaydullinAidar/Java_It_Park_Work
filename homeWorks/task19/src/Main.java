public class Main {

    public static void main(String[] args) {

        Transport car1 = new Car("a213er");
        Transport car2 = new Car();
        Transport moto1 = new Motorcycle("asd23sdf");
        Transport moto2 = new Motorcycle();
        Transport bike = new Bike();

        ParkingPlace parking = new ParkingPlace();

        parking.park(car1);
        parking.park(car2);
        parking.park(moto1);
        parking.park(moto2);
        parking.park(bike);
        parking.unpark(car1);


        for (int i = 0; i < parking.transports.length; i++) {
            if (parking.transports[i] != null) {
                System.out.println(parking.transports[i].toString());
            }
        }
    }
}
