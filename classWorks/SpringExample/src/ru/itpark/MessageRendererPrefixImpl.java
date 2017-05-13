package ru.itpark;

public class MessageRendererPrefixImpl implements MessageRenderer {

    private String prefix;
    private Message message;

    public MessageRendererPrefixImpl(String prefix, Message message) {
        this.prefix = prefix;
        this.message = message;

    }

    @Override
    public void render() {
        System.out.println(prefix + " " + message.getText());
    }
}
