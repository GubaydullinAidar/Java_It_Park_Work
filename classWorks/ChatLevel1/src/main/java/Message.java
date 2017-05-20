/**
 * Created by Student9 on 15.05.2017.
 */
public class Message {
    private Author author;
    private String text;

    public Message(Author author, String text) {
        if (author == null) {
            throw new IllegalArgumentException("Author can not be null");
        }

        if (text == null) {
            throw new IllegalArgumentException("Text can not be null");
        }

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text can not be empty");
        }

        this.author = author;
        this.text = text;
    }

    public Author getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
