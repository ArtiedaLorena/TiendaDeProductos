package com.latam.lorena.tienda.prueba;

import com.latam.lorena.tienda.DAO.CategoriaDAO;
import com.latam.lorena.tienda.DAO.ProductoDAO;
import com.latam.lorena.tienda.modelo.Categoria;
import com.latam.lorena.tienda.modelo.Producto;
import com.latam.lorena.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class RegistroDeProducto {

    public static void main(String[] args) {
        registrarProducto();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO= new ProductoDAO(em);
        Producto producto= productoDAO.findById(1l);
        System.out.println(producto.getNombre());
        List<Producto> productos = productoDAO.findAll();
        productos.forEach(prod-> System.out.println(prod.getDescripcion()));

    }
    private static void registrarProducto() {
        //CICLO DE VIDA de una ENTIDAD
        //Categoria celulares= new Categoria("CELULARES");


        //INICIO DE CONEXION
        //EntityManager em= JPAUtils.getEntityManager();

        //em.getTransaction().begin();

        //em.persist("Libros");
        //Sincronizamos el valor en la vase de datos y el clear paso ese valor a un estado detached
        //em.flush();
        //em.clear();

        //Llamamos ese valor de la Base de datos con un estado managed y lo reasignamos a la entidad inicial
        //celulares = em.merge(celulares);
        //celulares.setNombre("SOFTWARE");

        //em.flush();
        //em.clear();

        //celulares = em.merge(celulares);
        //em.remove(celulares);
        //em.flush();
        
        Categoria celulares= new Categoria("Celulares");

        Producto celular= new Producto("Xiaomi", "legal", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO= new ProductoDAO(em);
        CategoriaDAO categoriaDAO= new CategoriaDAO(em);
        em.getTransaction().begin();
        categoriaDAO.guardar(celulares);
        productoDAO.guardar(celular);

        em.getTransaction().commit();
        em.close();

    }
}
