public class ParkingPlace {

    public Transport transports[];

    public void setTransports(Transport[] transports) {
        this.transports = transports;
    }

    public void park(Transport transport) {
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] == null) {
                if (transport.getNumber() != null) {
                    System.out.println("Здравствуйте, припаркуйтесь на место " + (i + 1));
                    transports[i] = transport;
                    transport.goToParking();
                    break;
                } else
                    System.out.println("Извините, парковка без номера запрещена.");
            }
            if (i == transports.length - 1) {
                System.out.println("Извините, все места заняты!");
            }
        }
    }

    public void unpark (Transport transport) {
        for (int i = 0; i < transports.length; i++) {
            if (transports[i].getNumber() == transport.getNumber()) {
                for (int j = i; j < transports.length - 1; j++) {
                    transports[j] = transports[j + 1];
                }
            }
        }

        transports[transports.length - 1] = null;
    }


}
