package com.xfq.web;

import com.xfq.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

public class FilterTransaction implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                try {
                    filterChain.doFilter(servletRequest,servletResponse);
                    JDBCUtils.commitAndClose();
                }catch (Exception e){
                    JDBCUtils.rollbackAndClose();
                    e.printStackTrace();
                }

    }

    @Override
    public void destroy() {

    }
}
