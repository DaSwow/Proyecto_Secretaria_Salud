package cliente;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private Socket socket;

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Boolean autorizacion;
    private String resultadoAgregarCita;

    public Client() {
        try {
            if (socket == null) {
                socket = new Socket("localhost", 1234);
                oos = new ObjectOutputStream(socket.getOutputStream());
                oos.flush();
                ois = new ObjectInputStream(socket.getInputStream());
                listenForMessage();
            }
        } catch (IOException e) {
            closeEverything(socket, ois, oos);
        }
    }

    public void sendMessage(String asunto, ArrayList mensaje) {
        try {
            ArrayList msg = new ArrayList();
            msg.add(asunto);
            msg.add(mensaje);
            oos.writeObject(msg);
            oos.flush();
        } catch (IOException e) {
            closeEverything(socket, ois, oos);
        }
    }

    public Boolean getAutorizacion() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (autorizacion != null) {
                return autorizacion;
            }
            
        }
    }

    public String getResultadoAgregarCita() {
        while (true) {
            if (resultadoAgregarCita != null) {
                return resultadoAgregarCita;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        ArrayList msgRecibido = (ArrayList) ois.readObject();
                        System.out.println(msgRecibido);
                        String asunto = (String) msgRecibido.get(0);
                        switch (asunto) {
                            case "Respuesta Credenciales":
                                autorizacion = (Boolean) msgRecibido.get(1);
                                break;
                            case "RespuestaAgregarCita":
                                ArrayList respuesta = (ArrayList) msgRecibido.get(1);
                                resultadoAgregarCita = (String) respuesta.get(0);
                            default:
                                break;
                        }
                    } catch (IOException e) {
                        closeEverything(socket, ois, oos);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception exx) {
                        exx.printStackTrace();
                    }
                }
            }
        }).start();
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
