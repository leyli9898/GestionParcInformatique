package controller;

import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import entities.Equipement;
import repository.EquipementRepository;

@WebServlet("/equipement/*")
public class EquipementController extends HttpServlet {
    private EquipementRepository equipementRepository = new EquipementRepository();
    private TemplateEngine templateEngine;
    // private JakartaServletWebApplication webApplication;
    @Override
    public void init()throws ServletException {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix(getServletInfo()+"template/");
        templateResolver.setSuffix(getServletInfo()+".html");
        templateResolver.setCharacterEncoding(getServletInfo()+"UTF-8");
        templateEngine=new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        equipementRepository=new EquipementRepository();
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    // String url = req.getPathInfo();
    
    // if (url == null || "/".equals(url)) {
    //     listEquipement(req, resp);
    // } else if ("/form".equals(url)) {
    //     getFormulaireEquipement(req, resp);
    // } else {
    //     resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
    // }
      }

 //    public void getFormulaireEquipement(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
 //   try{
 //     Equipement equipement = new Equipement();
 //     ServletContext servletContext = getServletContext();
 //     JakartaServletWebApplication application= JakartaServletWebApplication.buildApplication(servletContext);
 //     IWebExchange Exchange = application.buildExchange(req, resp);
 //     WebContext context = new WebContext(Exchange);
 //     context.setVariable(name:"equipemet", equipement);
 //     templateEngine.process(template:"formulaire", context,resp.getWriter());
 //    }catch(Exception  e){
 //     throw new ServerCloneException(,e);

 //    }
    public void listEquipement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     try {
        List<Equipement> listEquipement = equipementRepository.allEquipement();

        ServletContext servletContext = getServletContext();
        JakartaServletWebApplication webApplication = JakartaServletWebApplication.buildApplication(servletContext);
        IWebExchange iWebExchange = webApplication.buildExchange(req, resp);

        WebContext webContext = new WebContext(iWebExchange);
        webContext.setVariable("equipements", listEquipement); // "equipements" utilisé dans le template

        templateEngine.process("liste", webContext, resp.getWriter()); // "liste.html" dans /templates/
      } catch (Exception e) {
        e.printStackTrace();
        throw new ServletException(e);
      }
    }

    
    
    
}

