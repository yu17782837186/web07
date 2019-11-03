package com.ning.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
* session技术
*       问题：一个用户的不同请求处理数据共享问题
*       解决：使用session技术
*       原理：用户第一次访问服务器，服务器会创建一个session对象给此用户
*       并将该session对象的JSESSIONID使用cookie技术存储到浏览器中，保证此用户的其它
*       请求能够获取到同一个session对象，也保证了不同请求也能够获取到共享数据
*
*       特点：
*           存储在服务器端
*           服务器进行创建
*           依赖cookie技术
*           一次会话即浏览器没有关闭
*       作用：
*           解决了一个用户不同请求处理的数据共享问题
*       使用:
*           创建seesion对象/获取session对象
*           HttpSession hs = request.getSession();
*           如果请求中拥有session对象的标识符也就是JSESSIONID,则返回其对应的session对象
*           如果请求中没有session的标识符也就是JSESSIONID，则创建新的session对象，并将其JSESSIONID
*           作为cookie数据存储到浏览器的内存中
*           如果session对象失效了，也会重新创建一个session对象，并将其JSESSIONID存储在浏览器中
*       JSESSIONID存储在了cookie的临时存储空间中，浏览器关闭即失效
*
*       存储和获取数据：
*           存储：hs.setAttribute(String name,Object value);
*           获取：hs.getAttribute(String name);返回的数据为object类型
*
*       存储的动作和取出的动作发生在不同的请求中，但是存储要先于取出执行
*
*       使用的时机：
*           一般在用户登录web项目时会将用户的个人信息存储到session中，供该用户的其它请求使用
*
*       总结：
*           session解决了一个用户的不同请求数据共享的问题，只要在JSESSIONID和session对象不失效的情况下
*           用户的任意请求在处理时都能得到同一个session对象
*
*       作用域：
*           一次会话
*           在JSESSIONID和session对象不失效的情况下为当前整个项目内
*
* */
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String name = "小红";
        //处理请求信息
        //创建session对象
        HttpSession hs = request.getSession();
        //设置session对象的存储时间
//        hs.setMaxInactiveInterval(5);
        System.out.println(hs.getId());
        //设置session强制失效
//        hs.invalidate();
        //存储数据
        hs.setAttribute("name",name);
        //响应处理结果
        //直接响应
        response.getWriter().write("session");
        //请求转发
        //重定向
    }
}
