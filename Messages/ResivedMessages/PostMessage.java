package Messages.ResivedMessages;
import Messages.InformationToShow.*;

import java.io.Serializable;

public class PostMessage implements ResivedMessage , Serializable {

    private User sender;
    private String text;

    @Override
    public void Allert() {
        pushedMessage();
    }

    private void pushedMessage(){
        sender.updatePost(text);
    }
}
