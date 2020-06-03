// NAME : Darshan Dani
// UTA ID : 1001764937

// A new instance of this class is created everytime a new client thread is successfully run.

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class ClientHandler implements Runnable {

    private String name;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Socket s;

    public ClientHandler(Socket s, String name, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) {

        this.objectInputStream = objectInputStream;
        this.objectOutputStream = objectOutputStream;
        this.name = name;
        this.s = s;
    }

    @Override
    public void run() {

        while(true) {

            try {

                Message message = (Message) objectInputStream.readObject();

                String clientName = message.getClientName();
                String msgFromClient = message.getMessage();

                Server.txtServerLog.append(clientName + " sent "+ msgFromClient+'\n');

                for(ClientHandler clients: Server.ar) {

                    Message message1 = new Message();
                    message1.setMessage(msgFromClient);
                    message1.setClientName(message.getClientName());
                    clients.objectOutputStream.writeObject(message1);
                }

            }
            catch (Exception e) {

                Server.clients.remove(name);
                Server.disconnectedClient = name;
                Server.printClients();

                e.printStackTrace();

            }
        }
    }
}