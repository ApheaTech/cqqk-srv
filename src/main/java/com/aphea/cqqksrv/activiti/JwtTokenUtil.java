package com.aphea.cqqksrv.activiti;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author 航
 * @date 2022/7/31 20:06
 */
@Slf4j
public class JwtTokenUtil {

    /**
     * 盐
     */
    public static String SECRET = "79e7c61239681b8270162386e6daa53d1dd";
    private static final long EXPIRATION = 28800000000L;

    /*生成token*/
    public static <T> String generateToken(T t) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        Date now = new Date();
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        JWTCreator.Builder token = JWT.create()
                .withHeader(map)
                .withExpiresAt(expireDate)
                .withIssuedAt(now)
                .withNotBefore(now);
        if (t instanceof Map) {
            ((Map) t).forEach((k, v) -> token.withClaim(k + "", v + ""));
        } else {
            BeanUtil.beanToMap(t).forEach((x, y) -> token.withClaim(x, y + ""));
        }
        return token.sign(Algorithm.HMAC256(SECRET));
    }

    /*解析token*/
    public static <T> T parseToken(String token, Class<T> aclass) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        HashMap<String, Object> hashMap = new HashMap<>();
        claims.forEach((k, v) -> hashMap.put(k, v.asString()));
        T t = BeanUtil.mapToBean(hashMap, aclass, false, CopyOptions.create());
        log.info("解析Token的内容:" + t);
        return t;
    }

    /*解析token*/
    public static <T> T parseToken001(String token, Class<T> aclass) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        String string = claims.get("loginId").asString();
        T t = JSON.parseObject(string, aclass);
        log.info("解析Token的内容:" + t);
        return t;
    }
}
