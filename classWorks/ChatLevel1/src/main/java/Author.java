/**
 * Created by Student9 on 15.05.2017.
 */
public class Author {
    private String nickname;

    public Author(String nickname) {

        if (nickname == null) {
            throw new IllegalArgumentException("Nickname can not be null");
        }

        if (nickname.isEmpty()) {
            throw new IllegalArgumentException("Nickname can not be empty");
        }

        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
