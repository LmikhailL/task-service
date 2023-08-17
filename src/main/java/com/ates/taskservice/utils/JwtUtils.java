package com.ates.taskservice.utils;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.StringUtils.hasText;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JwtUtils {

  private static final String BEARER_TOKEN_PREFIX = "Bearer ";
  private static final int TOKEN_START_POSITION = 7;
  private static final char DOT = '.';

  public static String getTokenFromRequest(ServletRequest request) {
    String bearer = ((HttpServletRequest) request).getHeader(AUTHORIZATION);

    if (hasText(bearer) && bearer.startsWith(BEARER_TOKEN_PREFIX)) {
      return bearer.substring(TOKEN_START_POSITION);
    } else {
      throw new RuntimeException("Token is missing");
    }
  }

  public static String getJwtWithoutSignature(String jwt) {
    final int i = jwt.lastIndexOf(DOT);
    return jwt.substring(0, i + 1);
  }

  public static String getSimpleClaim(final String claimName, @NonNull final String jwt) {
    return Jwts.parser()
        .parseClaimsJwt(jwt)
        .getBody()
        .get(claimName, String.class);
  }
}
