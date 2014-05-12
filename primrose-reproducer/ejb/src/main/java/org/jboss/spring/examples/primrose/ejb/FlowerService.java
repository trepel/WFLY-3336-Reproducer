package org.jboss.spring.examples.primrose.ejb;

import java.util.List;

import javax.ejb.Local;

import org.jboss.spring.examples.primrose.entity.Flower;

@Local
public interface FlowerService
{
   List<Flower> getAllFlowers();


}
