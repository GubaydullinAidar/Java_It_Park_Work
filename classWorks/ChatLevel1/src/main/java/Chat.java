import java.util.List;

/**
 * Created by Student9 on 15.05.2017.
 */
public class Chat {
    private List<Message> messages = new ArrayList<>();

    public List<Message> getLastMessages() {
        return messages.subList(messages.size(), messages.size() - 50);
    }

    public void addMessage (Message message) {
        messages.add(message);
    }
}
