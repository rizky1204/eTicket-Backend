package System.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
        if (request.getHeader("Origin") != null) {
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Authorization, X-Requested-With, Content-Type, Accept");
            response.addHeader("Access-Control-Max-Age", "1800"); // 30 min
            response.addHeader("Access-Control-Expose-Headers", "Total-Count, Total-Pages, Error-Message");
        }
        filterChain.doFilter(request, response);
    }
}
