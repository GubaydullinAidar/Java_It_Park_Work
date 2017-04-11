import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int ages[] = new int[121];

        People peoples[] = new People[300];
        for (int i = 0; i < peoples.length; i++) {
            People people = new People(random.nextInt(120) + 1);
            peoples[i] = people;
        }

        for (int j = 0; j < peoples.length; j++) {
            if (ages[peoples[j].getAge()] >= 0) {
                ages[peoples[j].getAge()]++;
            } else
                ages[peoples[j].getAge()] = 0;
        }

        for (int k = 0; k < ages.length; k++) {
            if (ages[k] != 0)
                System.out.println(k + " - " + ages[k]);
        }
    }
}
