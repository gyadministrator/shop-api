package com.gy.shop.shopapi.annotation.resolvers;

import com.gy.shop.shopapi.annotation.CurrentUser;
import com.gy.shop.shopapi.config.Constants;
import com.gy.shop.shopapi.entity.User;
import com.gy.shop.shopapi.jwt.utils.Audience;
import com.gy.shop.shopapi.jwt.utils.JwtUtils;
import com.gy.shop.shopapi.service.UserService;
import io.jsonwebtoken.Claims;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 获取当前登录对象，在jwt中带有user对象id
 *
 * @author gy
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {


    /**
     * 通过Key获得用户模型的实现类
     */


    private final UserService userService;

    private final Audience audienceEntity;

    @Autowired
    public CurrentUserMethodArgumentResolver(UserService userService, Audience audience) {
        this.userService = userService;
        this.audienceEntity = audience;
    }

    /**
     * Whether the given {@linkplain MethodParameter method parameter} is
     * supported by this resolver.
     *
     * @param parameter the method parameter to check
     * @return {@code true} if this resolver supports the supplied parameter;
     * {@code false} otherwise
     */
    @Override
    public boolean supportsParameter(@NotNull MethodParameter parameter) {
        //如果参数类型是User并且有CurrentUser注解则支持
        return parameter.getParameterType().isAssignableFrom(User.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class);
    }

    /**
     * Resolves a method parameter into an argument value from a given request.
     * A {@link ModelAndViewContainer} provides access to the model for the
     * request. A {@link WebDataBinderFactory} provides a way to create
     * a {@link WebDataBinder} instance when needed for data binding and
     * type conversion purposes.
     *
     * @param parameter     the method parameter to resolve. This parameter must
     *                      have previously been passed to {@link #supportsParameter} which must
     *                      have returned {@code true}.
     * @param mavContainer  the ModelAndViewContainer for the current request
     * @param webRequest    the current request
     * @param binderFactory a factory for creating {@link WebDataBinder} instances
     * @return the resolved argument value, or {@code null}
     * @throws Exception in case of errors with the preparation of argument values
     */
    @NotNull
    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter, @NotNull ModelAndViewContainer mavContainer, @NotNull NativeWebRequest webRequest, @NotNull WebDataBinderFactory binderFactory) throws Exception {
        //取出鉴权时存入的登录用户Id
        Object object = webRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (object != null) {
            String auth = object.toString().substring(7, object.toString().length());
            Claims claims = JwtUtils.parseJWT(auth, audienceEntity.getBase64Secret());
            if (claims == null) {
                //有key但是得不到用户，抛出异常
                throw new MissingServletRequestPartException(Constants.JWT_LOGIN_USER);
            }
            String key = String.valueOf(claims.get(Constants.LOGIN_USER));

            //从数据库中查询并返回
            User userModel = userService.findByName(key);

            if (userModel != null) {
                return userModel;
            }
        }
        //没有key就直接 抛出异常
        throw new MissingServletRequestPartException(Constants.GET_TOKEN_FAILURE);
    }
}
