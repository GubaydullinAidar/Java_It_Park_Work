public class Main {

    public static int arrCharToStr (char arrChar[]) {
        String result = "";
        for (int i = 0; i < arrChar.length; i++) {
            result += arrChar[i];
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        char arr[] = {'1', '2', '3', '4', '5'};
        System.out.println(arrCharToStr(arr));
    }
}
