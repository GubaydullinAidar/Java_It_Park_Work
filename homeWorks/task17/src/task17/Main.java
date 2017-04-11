package task17;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    People arrPeoples[] = new People[10];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраста людей:");

        for (int i = 0; i < arrPeoples.length; i++) {
            System.out.print((i + 1) + " - " );
            People people = new People(scanner.nextInt());
            arrPeoples[i] = people;
        }

        Sort.sortAgePeoples(arrPeoples);

        System.out.println("Возраста людей по возрастанию:");
        for (int i = 0; i < arrPeoples.length; i++) {
            System.out.println((i + 1) + " - " + arrPeoples[i].getAge());
        }




    }
}
