package com.xznn.servlet;


import com.xznn.bean.Hero;
import com.xznn.dao.HeroDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HeroListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        List<Hero> heros = new HeroDAO().list();

        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>edit</td><td>delete</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='editHero?id=%d'>edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";
        for (Hero hero : heros) {
            String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId(), hero.getId());
            sb.append(tr);
        }
        sb.append("</table>");

        sb.append("<a href='addHero.html'>新增</a>");

        resp.getWriter().write(sb.toString());

    }
}