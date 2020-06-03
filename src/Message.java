// NAME : Darshan Dani
// UTA ID : 1001764937

// This class contains the getters and setters for the code
import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

    String clientName;
    String message;
    String receiver;

    List<String> connectedClients;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public List<String> getConnectedClients() {
        return connectedClients;
    }

    public void setConnectedClients(List<String> connectedClients) {
        this.connectedClients = connectedClients;
    }
}
