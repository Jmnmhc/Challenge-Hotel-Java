package com.alura.hotel.controller;

import java.util.List;

import com.alura.hotel.dao.LoginDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Empleados;

public class LoginController {
	private String login;

	public String getLogin() {
		
		return login;
	}

	public void setLogin(String login) {
		
		this.login = login;
	}
	

    private LoginDAO loginDAO;

    public LoginController() {
        var factory = new ConnectionFactory();
        this.loginDAO = new LoginDAO(factory.recuperaConexion());
    }

    public List<Empleados> listar() {
        return this.loginDAO.listar();
    }
	
	public boolean usrPassOk (String user, String contrasena) {
		
		Empleados empleado = new Empleados(user, contrasena);
		if (empleado.getUser()==user && empleado.getPass()==contrasena) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
}
