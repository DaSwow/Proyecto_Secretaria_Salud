/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cita;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author carls
 */
public class CitaDao extends BaseDao<ArrayList>{

    @Override
    public ArrayList agregar(ArrayList entidad){
        ArrayList respuesta = new ArrayList();
        try {
            UsuarioDao ud= new UsuarioDao();
            Usuario doctor = ud.buscarPorCredencial((String)entidad.get(1));
            Cita cita = new Cita(doctor.getIdusuarios(), (String)entidad.get(0));
            
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(cita);
            entityManager.getTransaction().commit();
            
            
            respuesta.add("Agregado");
            return respuesta;
        } catch (Exception e) {
            respuesta.add("NoAgregado");
            e.printStackTrace();
            return respuesta;
        }
    }

    @Override
    public void eliminar(ArrayList entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(ArrayList entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList buscarPorId(Integer entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List mostrarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
