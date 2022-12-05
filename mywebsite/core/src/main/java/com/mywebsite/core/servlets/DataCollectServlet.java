package com.mywebsite.core.servlets;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.graalvm.compiler.nodeinfo.Verbosity.Id;


@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths=" + "/bin/submitdata3" })
public class DataCollectServlet extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(DataCollectServlet.class);
    @Override
    protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp) {
        try {
            ResourceResolver resourceResolver = req.getResourceResolver();
            Resource resource = resourceResolver.getResource("/content/Users");
            log.info("Resource is at path {}", resource.getPath());
            Node node = resource.adaptTo(Node.class);
            Node newNode = node.addNode(getNodeName(req,"NodeModel"), "nt:unstructured");

//            newNode.setProperty("name", "Demo NodeModel");
            newNode.setProperty("Fullname", getRequestParameter(req,"Fullname"));

            newNode.setProperty("age",getRequestParameter(req,"age"));
            newNode.setProperty("phoneNo",getRequestParameter(req,"phoneNo"));
            newNode.setProperty("dob",getRequestParameter(req,"dob"));

//            resp.getWriter().write("Form submitted");
            resp.sendRedirect("/content/mywebsite/us/en/newform.html");
            resourceResolver.commit();

        } catch (RepositoryException e) {

            log.error(e.getMessage(), e);

            e.printStackTrace();

        } catch (PersistenceException e) {

            log.error(e.getMessage(), e);

            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getRequestParameter(SlingHttpServletRequest request,String s) {
        String var= request.getParameter(s);
        return var;
    }

    public static String getNodeName(SlingHttpServletRequest request,String s) {

        String Phone= request.getParameter("phoneNo");

        String UserNodeName= Phone;
        return UserNodeName;
    }
}