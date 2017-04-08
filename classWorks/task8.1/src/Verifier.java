/**
 * Created by Student9 on 08.04.2017.
 */
public class Verifier {

    public static void verify(String password) {
        if (password.length() > 6) {
            throw new PasswordExeption();
        }
    }
}
