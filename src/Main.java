import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8091;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 // ждем подключения
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.println("Write your name?");
                final String name = in.readLine();
                System.out.println(name);
                out.println("Are you child? (yes/no)");
                final String answer = in.readLine();
                System.out.println(answer);
                if (answer.equals("yes")) {
                    out.println("Welcome to the kids area, " + name + "! Let's play!");
                } else if (answer.equals("no")) {
                    out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                } else {
                    out.println(name + "! type yes or no!");
                }
                final String bye = in.readLine();
                System.out.println(bye);
                out.println(bye);
            }
        }
    }
}
