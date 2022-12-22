package id.unifi.envsensorsapi.http.middleware;

import id.unifi.envsensorsapi.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
@PropertySource(value = "classpath:security.properties")
public class AuthMiddleware extends OncePerRequestFilter {

    private final List<String> publicRoutes = List.of(
            "/api/v1/measurements"
    );

    private static final String AUTH_HEADER_NAME = "X-Custom-Auth";

    @Value("${auth-header-value}")
    private String authHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        var header = request.getHeader(AUTH_HEADER_NAME);
        var path = request.getRequestURI();

        if (isValidAuthHeader(header, path)) {
            filterChain.doFilter(request, response);
        } else {
            LoggerUtil.info("Request denied for " + path);
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }

    private boolean isValidAuthHeader(String header, String path) {
        return !publicRoutes.contains(path) || Objects.equals(header, authHeader);
    }

}
