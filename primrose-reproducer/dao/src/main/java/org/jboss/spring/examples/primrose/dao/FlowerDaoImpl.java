package org.jboss.spring.examples.primrose.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.spring.examples.primrose.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;

public class FlowerDaoImpl implements FlowerDao {

    @Autowired
    EntityManager em;

    public List<Flower> getAllFlowers() {
        return em.createQuery("from Flower").getResultList();
    }

}
