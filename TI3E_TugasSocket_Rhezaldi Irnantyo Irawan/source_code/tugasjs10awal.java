import java.net.*;
import java.io.*;

public class tugasjs10awal {

    public static void main(String[] args) {
        ServerSocket theServer;
        for (int i = 500; i <= 1000; i++) {
            try {
                theServer = new ServerSocket(i);
                theServer.close();
            } catch (IOException e) {
                System.out.println("There is a server on port " + i + ".");
            }
        }
    }
}
