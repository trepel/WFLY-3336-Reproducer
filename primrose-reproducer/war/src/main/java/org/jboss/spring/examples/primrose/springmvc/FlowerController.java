package org.jboss.spring.examples.primrose.springmvc;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.spring.examples.primrose.ejb.FlowerService;
import org.jboss.spring.examples.primrose.entity.Flower;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlowerController
{
   private static final Double CAN_VOLUME = 0.5d;

   @EJB(mappedName = "java:app/primrose-ejb/FlowerServiceImpl")
   FlowerService flowerService;

   @RequestMapping(value = "/searchFlowers.do")
   ModelAndView getAllFlowers()
   {
      List<Flower> flowers = flowerService.getAllFlowers();

      ModelAndView model = new ModelAndView("listFlowers");
      model.addObject(flowers);
      return model;
   }

}
