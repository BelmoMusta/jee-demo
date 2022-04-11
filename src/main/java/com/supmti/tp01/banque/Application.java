package com.supmti.tp01.banque;

import com.supmti.tp01.banque.service.impl.BanqueService;
import com.supmti.tp01.banque.service.api.BanqueServiceInterface;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Application  implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        BanqueServiceInterface service = new BanqueService();
        context.setAttribute("banqueService", service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
