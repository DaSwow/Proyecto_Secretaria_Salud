
package servidor;

import DAO.CitaDao;
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
            //Autentificacion
            case "Credenciales":
                //Validar respuesta
                UsuarioDao ud = new UsuarioDao();
                String credencial = (String)contenidoMensaje.get(0);
                String contrasena = (String)contenidoMensaje.get(1);
                
                respuesta.add("Respuesta Credenciales");
                respuesta.add(ud.autenticar(credencial, contrasena));
                return respuesta;
                //Sistema citas
            case "AgendarCita":
                CitaDao cd = new CitaDao();
                String credencialDoctor = (String)contenidoMensaje.get(0);
                String nssPaciente = (String)contenidoMensaje.get(1);
                
                
                ArrayList datosAgregar = new ArrayList();
                datosAgregar.add(credencialDoctor);
                datosAgregar.add(nssPaciente);
                respuesta.add("RespuestaAgregarCita");
                respuesta.add(cd.agregar(datosAgregar));
            default:
                respuesta.add("Error");
                return respuesta;
        }
    }

}
