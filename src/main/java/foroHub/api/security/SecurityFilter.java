package foroHub.api.security;

import foroHub.api.usuario.IRepositoryUsuario;
import foroHub.api.usuario.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private IRepositoryUsuario repositoryUsuario;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

      var authHeader = request.getHeader("Authorization");
              if(authHeader!= null ){
                 var  token= authHeader.replace("Bearer ","");
                  var subject = tokenService.getSubject(token);
                  if(subject != null){
                      var usuario = repositoryUsuario.findByCorreo(subject);
                      var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                              usuario.getAuthorities());
                      SecurityContextHolder.getContext().setAuthentication(authentication);
                  }

              }

        filterChain.doFilter(request, response);
    }
}
