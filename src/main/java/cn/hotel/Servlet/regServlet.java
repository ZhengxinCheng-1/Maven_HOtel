package cn.hotel.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hotel.Utils.DButils;

public class regServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + ";"+ password);
		try (Connection conn = DButils.getConnection();){
			System.out.println("链接成功");
			String sql = "insert into customer values(null,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("注册成功");
			PrintWriter pw = resp.getWriter();
			pw.print("Successful!");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
