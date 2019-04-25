package com.photo.api.interceptor;

import com.google.gson.Gson;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.common.tools.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Gson gson = new Gson();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String token =  request.getHeader("token");
       if(token == null) {
           token = request.getParameter("token");
       }
       if(token!=null){
           Map map = JwtUtils.checkToken(token);
           if(map!=null){
               request.setAttribute("u_id",map.get("u_id"));
               request.setAttribute("u_nickName",map.get("u_nickName"));
               request.setAttribute("u_avatar",map.get("u_avatar"));
               return true;
           }
       }
       sendLoginMessage(response,ResultUtil.error(ResultEnum.INVALID_TOKEN.getMsg()));
       return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    public static void sendLoginMessage(HttpServletResponse response, Result result){
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print(gson.toJson(result));
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
