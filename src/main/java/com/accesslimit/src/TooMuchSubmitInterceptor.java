package com.accesslimit.src;

import com.accesslimit.src.AccessLimit;
import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * 防止恶意刷接口的拦截器
 */
@Slf4j
@Component
public class TooMuchSubmitInterceptor implements HandlerInterceptor {

    @Resource(name = "stringRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 请求前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        //获取注解的类
        Class<?> clazz = method.getMethod().getDeclaringClass();
        //获取方法上的注解
        AccessLimit accessLimit = method.getMethodAnnotation(AccessLimit.class);
        if (null != clazz.getDeclaredAnnotation(RestController.class) && null != accessLimit) {
            AccessLimit accessLimit0 = clazz.getDeclaredAnnotation(AccessLimit.class);
            int seconds = this.getValues(accessLimit0, accessLimit)[0];
            int maxCount = this.getValues(accessLimit0, accessLimit)[1];
            String ip = this.getRemoteIP(request);
            String key = request.getServletPath() + ":" + request.getMethod() + ":" + ip;
            String string = redisTemplate.opsForValue().get(key);
            int count = Integer.parseInt(null == string ? "0" : string);
            if (count > maxCount) {
                response.setContentType("application/json;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                PrintWriter out;
                out = response.getWriter();
                out.write(JSON.toJSONString("FAIL", "请求过于频繁，请" + seconds + "秒后再试"));
                out.flush();
                return false;
            }
        }
        return true;
    }

    /**
     * 请求处理后，视图渲染前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 视图渲染完成后调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        Class<?> clazz = method.getMethod().getDeclaringClass();
        AccessLimit accessLimit = method.getMethodAnnotation(AccessLimit.class);
        if (null != clazz.getDeclaredAnnotation(RestController.class) && null != accessLimit) {
            AccessLimit accessLimit0 = clazz.getDeclaredAnnotation(AccessLimit.class);
            int seconds = this.getValues(accessLimit0, accessLimit)[0];
            String ip = this.getRemoteIP(request);
            String key = request.getServletPath() + ":" + request.getMethod() + ":" + ip;
            redisTemplate.opsForValue().increment(key, 1);
            redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        }
    }


    private int[] getValues(AccessLimit accessLimit0, AccessLimit accessLimit) {
        int seconds = accessLimit.seconds();
        int maxCount = accessLimit.maxCount();
        if (null != accessLimit0 && 1 != seconds && 5 != maxCount) {
            seconds = accessLimit0.seconds();
            maxCount = accessLimit0.maxCount();
        }
        return new int[]{seconds, maxCount};
    }

    /**
     * 获取真实ip
     */
    private String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("X-Real-IP") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("X-Real-IP");
    }

}
