package com.bonsaiBackend.bonsaiBackend.Security.Jwt;

import com.bonsaiBackend.bonsaiBackend.Security.Modelo.UsuarioPrincipal;
import com.bonsaiBackend.bonsaiBackend.Security.Servicio.UsuarioDetallesServicioImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFiltro extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFiltro.class);
    @Autowired
    JwtProveedor jwtProveedor;

    @Autowired
    UsuarioDetallesServicioImpl usuarioDetallesServicio;

    @Override
    protected void doFilterInternal(HttpServletRequest Req, HttpServletResponse Res, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(Req);
            if (token != null && jwtProveedor.validateToken(token)){
                String nombreUsuario = jwtProveedor.getNombreUsuarioFromToken(token);
                UserDetails userDetails = usuarioDetallesServicio.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (Exception e){
            logger.error("Falla en el método doFilter" + e.getMessage());
        }
        filterChain.doFilter(Req, Res);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer"))
                return header.replace("Bearer", "");
        return null;
    }
}
