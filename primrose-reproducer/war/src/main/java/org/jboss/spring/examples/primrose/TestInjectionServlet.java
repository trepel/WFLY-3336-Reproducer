package org.jboss.spring.examples.primrose;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.spring.examples.primrose.ejb.FlowerService;
import org.jboss.spring.examples.primrose.entity.Flower;

public class TestInjectionServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Context ctx;
        FlowerService fs = null;
        try {
            ctx = new InitialContext();
            fs = (FlowerService) ctx.lookup("java:comp/env/ejb/FlowerServiceImpl");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("cant find java:comp/env/ejb/FlowerServiceImpl");
        }

        List<Flower> flowers = fs.getAllFlowers();


        response.getWriter().println("DONE: " + flowers.size());
    }

}
