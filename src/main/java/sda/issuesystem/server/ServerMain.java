package sda.issuesystem.server;

import sda.issuesystem.dto.DataTransferObject;
import sda.issuesystem.dto.User;
import sda.issuesystem.server.process.ProcessFactory;
import sda.issuesystem.server.repository.UserRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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

                DataTransferObject dto = (DataTransferObject) objectInputStream.readObject();
                System.out.println(dto.getObject());
                ProcessFactory.processChoice(dto).process(dto.getObject());
                objectOutputStream.writeObject(dto);
                objectOutputStream.flush();

                if (dto == null){
                    break;
                }
            }

            clientSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
