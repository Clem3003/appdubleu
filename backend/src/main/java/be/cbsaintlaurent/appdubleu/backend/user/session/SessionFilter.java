package be.cbsaintlaurent.appdubleu.backend.user.session;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.http.HttpHeaders;

@Component
public class SessionFilter {
    private final InMemorySessionRegistery sessionRegistery;
//    private final CurrentUserService currentUserService;

    @Autowired
    public SessionFilter(InMemorySessionRegistery sessionRegistery) {
        this.sessionRegistery = sessionRegistery;
    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        final String sessionId = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (sessionId == null || sessionId.length() == 0) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String username = sessionRegistery.getUsernameForSession(sessionId);
//        if(username == null) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//
//    }
}
