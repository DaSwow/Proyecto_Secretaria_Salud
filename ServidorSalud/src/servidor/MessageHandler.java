
package servidor;

import DAO.UsuarioDao;
import java.util.ArrayList;

/**
 *
 * @author carls
 */
public class MessageHandler {

    public ArrayList calcularRespuesta(String asunto, ArrayList contenidoMensaje) {
        ArrayList respuesta = new ArrayList();
        switch (asunto) {
            case "Credenciales":
                //Validar respuesta
                UsuarioDao ud = new UsuarioDao();
                String credencial = (String)contenidoMensaje.get(0);
                String contrasena = (String)contenidoMensaje.get(1);
                
                respuesta.add("Respuesta Credenciales");
                respuesta.add(ud.autenticar(credencial, contrasena));
                return respuesta;
            default:
                respuesta.add("Error");
                return respuesta;
        }
    }

}
