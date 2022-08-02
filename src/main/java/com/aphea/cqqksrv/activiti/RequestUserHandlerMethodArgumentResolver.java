package com.aphea.cqqksrv.activiti;

import com.aphea.cqqksrv.entity.TUser;
import lombok.AllArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author 航
 * @date 2022/7/31 20:04
 */
@Component
@AllArgsConstructor
public class RequestUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private SecurityUtil securityUtil;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(User.class);
    }

    @Override
    public TUser resolveArgument(MethodParameter methodParameter,
                                    ModelAndViewContainer modelAndViewContainer,
                                    NativeWebRequest nativeWebRequest,
                                    WebDataBinderFactory webDataBinderFactory) {

        HttpServletRequest request = ((ServletWebRequest) nativeWebRequest).getRequest();
        String token = null;
        token = request.getParameter("Authorization");
        if (token == null) {
            token = request.getHeader("Authorization");
        }
        if (token == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("Authorization".equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            }
        }

        Assert.notNull(token, "未检测到token");

        TUser tUser = JwtTokenUtil.parseToken(token, TUser.class);
        //这一步Activiti7需要
        securityUtil.logInAs(tUser.getUserId());
        return tUser;
    }
}
