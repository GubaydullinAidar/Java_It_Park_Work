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
    public void goToParking() {
        System.out.println("Спасибо, заезжаю парковаться.");
    }

    @Override
    public void goFromParking() {
        System.out.println(this.number + " спасибо, выезжаю.");
    }

    @Override
    public String toString() {
        return "Transport{" +
                "number='" + number + '\'' +
                '}';
    }
}