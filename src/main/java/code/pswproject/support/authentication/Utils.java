package code.pswproject.support.authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;


@UtilityClass
@Log4j2
public class Utils {

    public Jwt getPrincipal() {
        return (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public String getName() {
        return getTokenNode().get("sub").asText();
    }

    private JsonNode getTokenNode() {
        Jwt jwt = getPrincipal();
        ObjectMapper objectMapper = new ObjectMapper();
        String jwtAsString;
        JsonNode jsonNode;
        try {
            jwtAsString = objectMapper.writeValueAsString(jwt);
            jsonNode = objectMapper.readTree(jwtAsString);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException("No info found");
        }
        return jsonNode;
    }

}