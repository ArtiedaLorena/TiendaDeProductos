package com.latam.lorena.tienda.DAO;

import com.latam.lorena.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductoDAO {
    private EntityManager em;

    public ProductoDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Producto producto){
        this.em.persist(producto);
    }

    public Producto findById(Long id){
     return em.find(Producto.class, id);
    }

    public List<Producto> findAll(){
        String jpql= "SELECT P FROM Producto AS P";
        return em.createQuery(jpql,Producto.class).getResultList();
    }

    public List <Producto>findByName(String nombre){
        String jpql = "SELECT p FROM Producto AS P WHERE P.nombre =:nombre";
        return em.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Producto> findByCategory(String nombre){
        String jpql ="SELECT p FROM Producto AS P WHERE P.categoria.nombre = : nombre";
        return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public BigDecimal findPriceByName(String nombre){
        String jpql= "SELECT P.precio FROM Producto AS P WHERE P.nombre=.nombre";
        return em.createQuery(jpql,BigDecimal.class).setParameter("nombre",nombre).getSingleResult();

    }
}
