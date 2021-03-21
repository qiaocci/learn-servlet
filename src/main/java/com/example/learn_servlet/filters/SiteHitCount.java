package com.example.learn_servlet.filters;


import javax.servlet.*;
import java.io.IOException;

public class SiteHitCount implements Filter {
    private int hitCount;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        hitCount = 0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        hitCount++;
        System.out.println("网站访问统计" + hitCount);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
