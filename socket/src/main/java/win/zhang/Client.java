package win.zhang;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8081);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        while (true) {
            String str = bufferedReader.readLine();
            bufferedWriter.write(str);
            bufferedWriter.write("\n");
            bufferedWriter.flush();
        }
    }
}
