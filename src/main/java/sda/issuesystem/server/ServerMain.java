package sda.issuesystem.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);

            Socket clientSocket = serverSocket.accept();
            System.out.println("New Connection");
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {

                Object o = objectInputStream.readObject();
                System.out.println(o);
                objectOutputStream.writeObject("Server Response");
                objectOutputStream.flush();

                if (o == null){
                    break;
                }
            }

            clientSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
