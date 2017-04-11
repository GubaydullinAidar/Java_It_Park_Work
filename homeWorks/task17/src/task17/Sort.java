package task17;

public class Sort {
    public static void sortAgePeoples (People arrPeoples[]) {
        int tmp;
        for (int i = 0; i < arrPeoples.length; i++) {
            for (int j = arrPeoples.length - 1; j > i; j--) {
                if (arrPeoples[j].getAge() < arrPeoples[j - 1].getAge()) {
                    tmp = arrPeoples[j - 1].getAge();
                    arrPeoples[j - 1].setAge(arrPeoples[j].getAge());
                    arrPeoples[j].setAge(tmp);
                }
            }
        }
    }
}
