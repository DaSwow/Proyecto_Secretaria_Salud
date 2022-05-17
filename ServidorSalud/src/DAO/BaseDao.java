/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Abarrotes
 */
public abstract class BaseDao<T> {
    
    protected EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ServidorSaludPU");
    protected EntityManager em = managerFactory.createEntityManager();

    public abstract T agregar(T entidad);

    public abstract void eliminar(T entidad);

    public abstract void actualizar(T entidad);

    public abstract T buscarPorId(Integer entidad);
    
    public abstract List<T> mostrarTodas();

    public EntityManager getEntityManager() {
        return em;
    }
}
