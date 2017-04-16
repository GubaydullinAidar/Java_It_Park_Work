public class ParkingPlace {

    public Transport transports[] = new Transport[20];

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
                    break;
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
                break;
            }
        }

        transports[transports.length - 1] = null;
    }


}
