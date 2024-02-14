
import java.io.*;
import java.net.*;
import java.util.*;
public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringRicevuta = null;
    String stringModificata = null;
    BufferedReader inDaiClient;
    DataOutputStream outVersoClient;

    public Socket attendi ()
    {
        try
        {
            System.out.println("SERVER in esecuzione...");
            server = new ServerSocket(6789);
            client = server.accept();
            server.close();
            inDaiClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore");
            System.exit(1);
        }
        return client;

    }
    public void  comunica(){
        try{
            System.out.println("benvenuto scrivi una frase e la trasformero in maiuscola. Attendo...");
            stringRicevuta = inDaiClient.readLine();
            System.out.println("hai scritto :"+stringRicevuta);
            stringModificata = stringRicevuta.toUpperCase();
            System.out.println("invio stringa...");
            outVersoClient.writeBytes(stringModificata+'\n');
            System.out.println("fine elaborazione ... notte");
            client.close();
        }
    }


}
