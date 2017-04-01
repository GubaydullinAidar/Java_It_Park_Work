public class Main {

    public static void sortHeroes(SuperHero arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].getEnemies() > arr[j + 1].getEnemies()) {
                    SuperHero tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Mytants mytants = new Mytants(5);
        Humans humans = new Humans(7);

        SuperHero heroes[] = {mytants, humans};
        sortHeroes(heroes);

        for (int i = 0; i < heroes.length; i++) {
            System.out.print(heroes[i] + " ");
        }
    }
}
