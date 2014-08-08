package org.jboss.spring.examples.primrose.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.jboss.spring.examples.primrose.dao.FlowerDao;
import org.jboss.spring.examples.primrose.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Stateless
@Local(FlowerService.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class FlowerServiceImpl extends SpringBeanAutowiringSupport implements FlowerService
{
   @Autowired
   private FlowerDao flowerDao;

   public FlowerDao getFlowerDao()
   {
      return flowerDao;
   }

   public void setFlowerDao(FlowerDao flowerDao)
   {
      this.flowerDao = flowerDao;
   }

   public List<Flower> getAllFlowers()
   {
      return flowerDao.getAllFlowers();
   }

}
