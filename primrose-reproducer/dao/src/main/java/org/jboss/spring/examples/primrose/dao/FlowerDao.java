package org.jboss.spring.examples.primrose.dao;

import java.util.List;

import org.jboss.spring.examples.primrose.entity.Flower;

public interface FlowerDao
{
   List<Flower> getAllFlowers();

}
