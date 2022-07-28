package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private static final String TOKEN_PREFIX = "Bearer ";

    @Value("${jwt.secret")
    private String secret;

    @Value("${jwt.expiration")
    private String expiration;

    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.valueOf(expiration));

        String jwtToken = Jwts.builder()
                .setIssuer("pessoa-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return TokenAuthenticationFilter.BEARER + jwtToken;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token == null) {
            return null;
        }

        Claims payload = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        Integer idUsuario = Integer.parseInt(payload.getId());
        if (idUsuario != null) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(idUsuario, null, Collections.emptyList());
            return usernamePasswordAuthenticationToken;
        }
        return null;
    }

}

