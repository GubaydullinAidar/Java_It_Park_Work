public class ParkingPlace {

    static String park[] = new String[10];

    public static void addToPark (String number) {
        for (int i = 0; i < park.length; i++) {
            if (park[i] == null) {
                park[i] = number;
                break;
            }
            if (i == park.length - 1) {
                System.out.println("Все места заняты!");
            }
        }
    }

    public static void delAtPark (String number) {
        for (int i = 0; i < park.length; i++) {
            if (number == park[i]) {
                for (int j = i; j < park.length - 1; j++) {
                    park[j] = park[j + 1];
                }
            }
        }

        park[park.length - 1] = null;
    }


}
