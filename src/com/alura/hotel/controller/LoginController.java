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

//    public List<Empleados> listar() {
//        return this.loginDAO.listar();
//    }
	
	public boolean usrPassOk (String user, String contrasena) {
		
		final boolean encontrado = true; //la inicializo en true para que me aceptr el login
		
		Empleados empleado = new Empleados(user, contrasena);

		List<Empleados> usrAlmacenado = loginDAO.listar(empleado);//.toString();		
		
		usrAlmacenado.stream().forEach(emp ->{		
		
			String comparaUsr = emp.getUser().toString() ;
			String comparaUsr2= user.toString();
			String comparaPass = emp.getPass().toString();
			String comparaPass2 = contrasena.toString();
			
					if (comparaUsr.equals(comparaUsr2) && comparaPass.equals(comparaPass2)) {
					//	encontrado = true;
						System.out.println("entro al IF (EN LOGINCONTROLLER)");
						
					}else {
						System.out.println("salio poADr el ELSE (EN LOGINCONTROLLER)");
					}
				
					
					
				});
			
			
		return encontrado;
//		if (empleado.getUser().equals(user) && empleado.getPass().equals(contrasena)) {
//			System.out.println("siiiiiiiiiiiiiiiiiiii ACA ENTRA?");
//			
//			return true;
//		}
//		
//		else {
//			
//			System.out.println("ahora aca no entra nunca, la puta madre");
//			return false;
//		}
//				return valeONo;
	}
	
}
