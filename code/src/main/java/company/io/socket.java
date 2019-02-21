package company.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class socket {

    public static void main(String[] args) {

        try(ServerSocket s = new ServerSocket(8189)) {
            try(Socket incoming = s.accept()){

                InputStream inputStream = incoming.getInputStream();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
