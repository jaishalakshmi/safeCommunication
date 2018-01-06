/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infrastructure;

import LocalSecurity.*;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author stula
 */
public class ServerMotion {
    public ServerMotion(int portNum){
        this.connect(portNum);
    }

    public void connect(int portNumber) {
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                System.out.println("Server is running");
                new ServerMotionThread(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            System.out.println("Could not listen on port " + portNumber);
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ServerMotion server = new ServerMotion(9735);
    }
}
