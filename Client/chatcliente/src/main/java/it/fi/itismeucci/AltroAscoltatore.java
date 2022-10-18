package it.fi.itismeucci;

import java.io.*;

public class AltroAscoltatore extends Thread{
    
    BufferedReader inDalServer;
    Thread client;

    public AltroAscoltatore (BufferedReader b, Thread ThreadClient){
        inDalServer = b;
        client = ThreadClient;
    }

    public void run(){
        String stringaRicevuta = null;

        try {
            stringaRicevuta = inDalServer.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (stringaRicevuta.equals("spegniti")){
            client.interrupt();
        }else{
            System.out.println("il thread ha ricevuto la stringa");
        }

        /* System.out.println("Ricevi <  " + stringaRicevuta);
        System.out.println("====="); */
    }
}
