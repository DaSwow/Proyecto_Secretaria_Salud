package servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.MessageHandler;

public class Server {

    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {

        private Socket socket;
        private ObjectInputStream ois;
        private ObjectOutputStream oos;
        MessageHandler mh = new MessageHandler();

        public ClientHandler(Socket socket) {
            try {
                this.socket = socket;
                oos = new ObjectOutputStream(this.socket.getOutputStream());
                oos.flush();
                ois = new ObjectInputStream(this.socket.getInputStream());
                System.out.println("Cliente Conectado");
            } catch (IOException e) {
                // Close everything more gracefully.
                closeEverything(this.socket, ois, oos);
            }
        }

        //Escucha mensajes permanentemente
        @Override
        public void run() {
            while (socket.isConnected()) {
                try {
                    ArrayList messageFromClient = (ArrayList) ois.readObject();
                    String asunto = (String) messageFromClient.get(0);
                    
                    switch (asunto) {
                        case "Credenciales":
                            broadcastMessage(mh.calcularRespuesta(asunto,(ArrayList)messageFromClient.get(1)));
                            break;
                        case "AgendarCita":
                            broadcastMessage(mh.calcularRespuesta(asunto,(ArrayList)messageFromClient.get(1)));
                            break;
                        default:
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    closeEverything(socket, ois, oos);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        }

        public void broadcastMessage(ArrayList messageToSend) throws IOException {
            try {
                oos.writeObject(messageToSend);
                oos.flush();
            } catch (IOException e) {
                closeEverything(socket, ois, oos);
            }

        }

        public void closeEverything(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
