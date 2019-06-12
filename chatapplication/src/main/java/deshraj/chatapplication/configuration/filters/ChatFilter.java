package deshraj.chatapplication.configuration.filters;

import deshraj.chatapplication.controller.ChatController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChatFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("########## Initiating ChatFilter filter ##########");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        LOGGER.info("This Filter is only called when request is mapped for /customer resource");

        //call next filter in the filter chain
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
