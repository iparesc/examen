package com.ipartek.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.examen.pojo.Animal;
import com.ipartek.model.AnimalesDAO;



/**
 * Servlet implementation class PruebaController
 */
@WebServlet("/animales")
public class AnimalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VIEW_INDEX = "animales/index.jsp";
	
	

	
	

	private RequestDispatcher dispatcher;
	
	private AnimalesDAO daoAnimales;
	

	// parametros comunes
	

	// parametros del Animal
	private int id;

	private String nombre;
	

	/**
	 * Se ejecuta solo la 1º vez que llaman al Servlet
	 */
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoAnimales = AnimalesDAO.getInstance();

	}

	/**
	 * Se ejecuta cuando Paramos Servidor de Aplicaciones
	 */

	public void destroy() {
		super.destroy();
		daoAnimales = null;
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Antes de Ejecutar doGET o doPost");

		super.service(request, response);
		System.out.println("Despues de Ejecutar doGET o doPost");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		listar(request);
		}catch(Exception e){
			
		}finally {
			dispatcher.forward(request, response);
		}
		
		
	}
	private void listar(HttpServletRequest request) {

		ArrayList<Animal> animales = new ArrayList<Animal>();
		animales = daoAnimales.getAll();
		request.setAttribute("animales", animales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}
	
}

