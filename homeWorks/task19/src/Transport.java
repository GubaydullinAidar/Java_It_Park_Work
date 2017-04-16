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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        return number.equals(transport.number);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public void goToParking() {
        System.out.println("Спасибо, заезжаю.");
    }

    @Override
    public void goFromParking() {
        System.out.println("Спасибо, выезжаю.");
    }

    @Override
    public String toString() {
        return "Transport{" +
                "number='" + number + '\'' +
                '}';
    }
}