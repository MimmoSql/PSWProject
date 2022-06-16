package code.pswproject.support.authentication;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class JwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Value("${keycloak.resource}")
    private String CLIENT_NAME;


    @Override
    @SuppressWarnings("unchecked")
    public AbstractAuthenticationToken convert(final Jwt source) { //source=token jwt
        Map<String, Object> resourceAccess = source.getClaim("resource_access");
        Map<String, Object> resource = (Map<String, Object>) resourceAccess.get(CLIENT_NAME); //utente nel token
        Collection<String> resourceRoles = (Collection<String>) resource.get("roles"); //ruoli dell'utente
        Set<GrantedAuthority> authorities = resourceRoles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet()); //permessi dell'utente
        return new JwtAuthenticationToken(source, authorities); //ritorniamo token
    }


}