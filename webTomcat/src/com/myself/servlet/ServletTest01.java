package com.myself.servlet;
import javax.servlet.*;
import java.io.IOException;

public class ServletTest01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("config");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet!");
    }

    @Override
    public String getServletInfo() {
        System.out.println("info");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("des");
    }
}
