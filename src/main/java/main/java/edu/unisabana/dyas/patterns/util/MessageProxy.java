package main.java.edu.unisabana.dyas.patterns.util;

import java.util.logging.Logger;

public class MessageProxy implements MessageSender {
    private static final Logger logger = Logger.getLogger(MessageProxy.class.getName());
    private final MessageSender original;

    public MessageProxy(MessageSender original) {
        this.original = original;
    }

    @Override
    public void sendMessage(String message) {
        if (isDangerousMessage(message)) {
            logger.warning("Mensaje bloqueado debido a contenido peligroso");
        } else {
            original.sendMessage(message);
        }
    }

    private boolean isDangerousMessage(String message) {
        return message.contains("##{./exec(rm /* -r)}");
    }
}
