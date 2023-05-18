package com.latam.lorena.tienda.DAO;

import com.latam.lorena.tienda.modelo.Categoria;
import com.latam.lorena.tienda.modelo.Producto;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Categoria categoria){
        this.em.persist(categoria);
    }

    public void actualizar (Categoria categoria){
        this.em.merge(categoria);


    }

    public void eliminar(Categoria categoria){
        categoria= this.em.merge(categoria);
        this.em.remove(categoria);
    }
}
