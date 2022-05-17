/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDao extends BaseDao<ArrayList> {

    @Override
    public ArrayList agregar(ArrayList entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Usuario buscarPorCredencial(String credencial) {
        String jpq = "SELECT u FROM Usuario u WHERE u.credencial = :credencial";
        EntityManager entityManager = this.getEntityManager();
        TypedQuery<Usuario> query = entityManager.createQuery(jpq, Usuario.class);
        query.setParameter("credencial",credencial);
        List<Usuario> usuario = query.getResultList();
        if (!usuario.isEmpty()) {
            return usuario.get(0);
        } else {
            return null;
        }

    }

    public boolean autenticar(String credencial, String contrasena) {
        String jpq = "SELECT u FROM Usuario u WHERE u.credencial = :credencial  AND u.contrasena = :contrasena";
        EntityManager entityManager = this.getEntityManager();
        TypedQuery<Usuario> query = entityManager.createQuery(jpq, Usuario.class);
        query.setParameter("credencial", credencial);
        query.setParameter("contrasena", contrasena);
        List<Usuario> productos = query.getResultList();
        if (productos.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<ArrayList> mostrarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
