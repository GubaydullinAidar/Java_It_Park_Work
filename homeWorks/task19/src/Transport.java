/**
 * Created by Администратор on 14.04.17.
 */
public abstract class Transport implements ParkingObject {

    private String number;

    @Override
    public String getNumber() {
        return this.number;
    }

    public Transport () {
        this.number = null;
    }

    public Transport(String number) {
        this.number = number;
    }

    @Override
    public void parking() {
        if (getNumber() != null) {
            System.out.println(this.number + " пожалуйста, припаркуйтесь.");
            ParkingPlace.addToPark(this.number);
        } else {
            System.out.println("Извините, без номера парковаться нельзя.");
        }
    }

    @Override
    public void unParking() {

        ParkingPlace.delAtPark(this.number);

        System.out.println(this.number + " спасибо, за парковку, счастливого пути.");
    }
}
