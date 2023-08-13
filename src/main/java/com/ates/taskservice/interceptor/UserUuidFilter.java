package com.ates.taskservice.interceptor;

import static com.ates.taskservice.utils.JwtUtils.getJwtWithoutSignature;
import static com.ates.taskservice.utils.JwtUtils.getSimpleClaim;
import static com.ates.taskservice.utils.JwtUtils.getTokenFromRequest;
import static com.ates.taskservice.utils.UserUuidHolder.remove;
import static com.ates.taskservice.utils.UserUuidHolder.setUuid;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserUuidFilter implements HandlerInterceptor {

  private static final String SUB_CLAIM = "sub";

  @Override
  public boolean preHandle(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull Object handler
  ) {
    try {
      final String token = getTokenFromRequest(request);
      final String jwtWithoutSign = getJwtWithoutSignature(token);
      final String uuid = getSimpleClaim(SUB_CLAIM, jwtWithoutSign);

      setUuid(uuid);
      return true;
    } finally {
      remove();
    }
  }
}
