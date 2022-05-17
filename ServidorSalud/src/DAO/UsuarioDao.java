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
    public void agregar(ArrayList entidad) {
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

//    @Override
//    public void agregar(Producto entidad) {
//          try {
//            EntityManager entityManager = this.getEntityManager();
//            entityManager.getTransaction().begin();
//            entityManager.persist(entidad);
//            entityManager.getTransaction().commit();
//
//            JOptionPane.showMessageDialog(null, "Se agrego nuevo producto", "Aviso", INFORMATION_MESSAGE);
//            System.out.println("Se agrego");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se pudo agregar el producto", "Aviso", ERROR_MESSAGE);
//            System.out.println("No se agrego");
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void eliminar(Producto entidad) {
//        try {
//            EntityManager entityManager = this.getEntityManager();
//            entityManager.getTransaction().begin();
//            Producto productoEliminado = entityManager.find(Producto.class, entidad.getId());
//            if (productoEliminado != null) {
//                entityManager.remove(productoEliminado);
//                System.out.println("Se ha eliminado con exito");
//            } else {
//                System.out.println("No se pudo eliminar");
//                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto", "Aviso", INFORMATION_MESSAGE);
//            }
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Huvo un error", "Aviso", ERROR_MESSAGE);
//           System.out.println("No se pudo eliminar");
//        }
//    }
//
//    @Override
//    public void actualizar(Producto entidad) {
//        try {
//             EntityManager entityManager = this.getEntityManager();
//             entityManager.getTransaction().begin();
//            Producto productoActualizado = entityManager.find(Producto.class, entidad.getId());
//            if (productoActualizado != null) {
//                productoActualizado.setNombre(entidad.getNombre());
//                productoActualizado.setPrecio(entidad.getPrecio());
//                productoActualizado.setCodigo(entidad.getCodigo());
//              
//                entityManager.merge(productoActualizado);
//                System.out.println("Se ha actualizado con exito");
//            } else {
//                JOptionPane.showMessageDialog(null, "No se encontro el producto", "Aviso", INFORMATION_MESSAGE);
//                System.out.println("No se pudo actualizar");
//            }
//            em.getTransaction().commit();
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, "Huvo un error", "Aviso", ERROR_MESSAGE);
//            System.out.println("No se pudo actualizar");
//        }
//    }
//
//    @Override
//    public Producto buscarPorId(Integer entidad) {
//        String jpq = "SELECT u FROM Producto u WHERE u.id = :id";
//            EntityManager entityManager = this.getEntityManager();
//        TypedQuery<Producto> query = entityManager.createQuery(jpq, Producto.class);
//        query.setParameter("id", entidad);
//        List<Producto> productos = query.getResultList();
//        if (productos.isEmpty()) {
//            System.out.println("No se pudo encontrar la venta");
//            return null;
//        } else {
//             Producto producto = productos.get(0);
//            return producto;
//        }
//    }
//
//    @Override
//    public List<Producto> mostrarTodas() {
//         String jpq = "SELECT u FROM Producto u";
//            EntityManager entityManager = this.getEntityManager();
//        TypedQuery<Producto> query = entityManager.createQuery(jpq, Producto.class);
//        List<Producto> productos = query.getResultList();
//        if (productos.isEmpty()) {
//            System.out.println("No hay ventas");
//            return null;
//        } else {
//            System.out.println("Mostrando todos los productos");
//            for (Producto producto : productos) {
//                System.out.println(producto);
//            }
//            return productos;
//        }
//    }
//    
//     public List<Producto> buscarPorNombre(String nombre) {
//        String jpq = "SELECT u FROM Producto u WHERE u.nombre LIKE :nombre";
//        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
//        query.setParameter("nombre", "%"+ nombre + "%");
//        List<Producto> productos = query.getResultList();
//        if (productos.isEmpty()) {
//            return productos;
//        } else {
//            System.out.println("Mostrando todos los productos");
//            for (Producto producto : productos) {
//                System.out.println(producto);
//            }
//            return productos;
//        }
//    }
//     
//    
//    public List<Producto> buscarPorCodigo(String codigo) {
//        String jpq = "SELECT u FROM Producto u WHERE u.codigo LIKE :codigo";
//        TypedQuery<Producto> query = em.createQuery(jpq, Producto.class);
//        query.setParameter("codigo", "%"+ codigo + "%");
//        List<Producto> productos = query.getResultList();
//        if (productos.isEmpty()) {
//              System.out.println("No hay productos");
//            return null;
//        } else {
//            System.out.println("Mostrando todos los productos");
//            for (Producto producto : productos) {
//                System.out.println(producto);
//            }
//            return productos;
//        }
//    }
}
