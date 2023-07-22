package dbexample.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;

import org.springframework.security.core.AuthenticationException;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.http.HttpRequest;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -7858869558953243875L;
//    @Override
//    public void commence(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            AuthenticationException authExcetion) throws IOException{
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
//    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
    }
}
