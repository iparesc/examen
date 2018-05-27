package com.ipartek.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.examen.pojo.Alert;
import com.ipartek.examen.pojo.Consulta;

import com.ipartek.model.UsuarioDAO;

/**
 * Servlet implementation class ConsultasControl
 */
@WebServlet("/codigo")
public class ConsultasControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String view = "";
	private String user="";
	private static final String VIEW_CONSULTAS = "codigos.jsp";
	private static final String VIEW_LOGIN = "login.jsp";
	private RequestDispatcher dispatcher;
	private Alert alert = new Alert();

	private UsuarioDAO dao;
	
	private static final int SESSION_EXPIRATION = -1; // No expira

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao= UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher(VIEW_CONSULTAS).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		guardar(request,response);
		
	}
		private void guardar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		Consulta consulta=new Consulta();
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("nombre");
		try {
			consulta.setNombre(user);
			consulta.setCode(request.getParameter("code"));
			
			dao.crear(consulta);
			
			view=VIEW_LOGIN;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
		
	}finally {
		request.getRequestDispatcher(view).forward(request, response);
	}
}
}
