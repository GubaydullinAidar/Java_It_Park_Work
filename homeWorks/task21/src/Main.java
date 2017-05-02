public class Main {

    public static int arrCharToStr (char arrChar[]) {
        int result = 0;
        int b = 1;
        for (int i = arrChar.length - 1; i >= 0; i--) {
            result = result + ((int)arrChar[i] - (int)'0') * b;
            b *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        char arr[] = {'1', '2', '3', '4', '5'};
        System.out.println(arrCharToStr(arr));
    }
}
