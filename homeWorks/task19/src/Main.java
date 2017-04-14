/**
 * Created by Администратор on 14.04.17.
 */
public class Main {

    public static void main(String[] args) {
        Transport car1 = new Car("a213er");
        Transport car2 = new Car();
        Transport moto1 = new Motorcycle("asd23sdf");
        Transport moto2 = new Motorcycle("asd23asd");
        Transport bike = new Bike();


        car1.parking();
        car2.parking();
        moto1.parking();
        moto2.parking();
        bike.parking();
        moto1.unParking();

        for (int i = 0; i < ParkingPlace.park.length; i++) {
            if (ParkingPlace.park[i] != null) {
                System.out.println(ParkingPlace.park[i]);
            }
        }
    }
}
