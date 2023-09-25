package it.fi.meucci;
import java.io.*;
import java.net.*;

public class Client {
    String serverName = "localhost";
    int serverPort = 7000;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaDalServer;
    DataOutputStream out;
    BufferedReader in;

    public Socket connetti(){
        System.out.println("2 CLIENT is running...");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket = new Socket(serverName, serverPort);
            out = new DataOutputStream(mioSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        } catch (Exception e) {
            System.out.println("Errore nella connessione");
        } 
        return mioSocket;
    }

    public void comunica(){
        try {
            System.out.println("4 Inserisci la stringa da trasmettere al server:"+"\n");
            stringaUtente = tastiera.readLine();
            System.out.println("5 invio la stringa al server");
            out.writeBytes(stringaUtente + "\n");

            stringaDalServer = in.readLine();
            System.out.println(" 8  risposta dal server " + "\n" + stringaDalServer);

            System.out.println("9 CLIENT : ending connection");
            mioSocket.close();
        } catch (Exception e) {
            System.out.println("Errore nella comunicazione");
        }
    }


}
