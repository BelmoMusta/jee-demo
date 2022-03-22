package com.supmti.tp01.banque;

import com.supmti.tp01.banque.service.BanqueService;
import com.supmti.tp01.banque.servlet.BanqueServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Application  implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        BanqueService service = new BanqueService();
        context.setAttribute("banqueService", service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
