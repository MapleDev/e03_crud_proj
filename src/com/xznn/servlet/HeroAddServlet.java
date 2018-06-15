package com.xznn.servlet;

import com.xznn.bean.Hero;
import com.xznn.dao.HeroDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroAddServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Hero hero = new Hero();
        hero.setName(req.getParameter("name"));
        hero.setHp(Float.parseFloat(req.getParameter("hp")));
        hero.setDamage(Integer.parseInt(req.getParameter("damage")));

        new HeroDAO().add(hero);

        resp.sendRedirect("/listHero");
    }

}
