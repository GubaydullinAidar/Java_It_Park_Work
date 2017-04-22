import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    ArrayList list = new ArrayList();

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        list.addFirst(x);
        list.addLast(y);
        list.addLast(a);
        list.addFirst(b);
        System.out.println(list.find(4));
        System.out.println(list.get(2));
        list.insert(5, 2);
        list.removeByIndex(1);
        list.reverse();
        list.size();
        list.print();
    }
}
