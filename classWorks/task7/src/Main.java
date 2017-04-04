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
        Mytants magnito = new Mytants(5, "Magnito");
        Mytants halk = new Mytants(3,"Halk");
        Mytants rosomaha = new Mytants(4, "Rosomaha");
        Humans batman = new Humans(7, "Batman");
        Humans robin = new Humans(2, "Robin");

        SuperHero heroes[] = {magnito, halk, rosomaha, robin, batman};
        sortHeroes(heroes);

        for (int i = 0; i < heroes.length; i++) {
            System.out.print(heroes[i].getName() + " ");
        }
    }
}
