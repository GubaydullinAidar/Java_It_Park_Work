public class Main {

    public static void main(String[] args) {

        Transport car1 = new Car("a213er");
        Transport car2 = new Car();
        Transport moto1 = new Motorcycle("asd23sdf");
        Transport moto2 = new Motorcycle();
        Transport bike = new Bike();

        Transport transports[] = {car1, car2, moto1, moto2, bike};
        ParkingPlace parking = new ParkingPlace();
        parking.setTransports(transports);


        for (int i = 0; i < parking.transports.length; i++) {
            if (parking.transports[i].getNumber() != null) {
                System.out.println(parking.transports[i].toString());
            }
        }
    }
}
