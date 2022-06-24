package com.alura.hotel.controller;

import com.alura.hotel.dao.ReservaDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reserva;

public class ReservaController {

			
	    private ReservaDAO reservasDao;
	    
	    public ReservaController () {
	    	var factory = new ConnectionFactory();
	    	this.reservasDao = new ReservaDAO(factory.recuperaConexion());
	    }
	    
	    
	    public void guardar (Reserva reserva) {
	    	System.out.println("guardar del reservas controller");
	    	reservasDao.guardar(reserva);
	    }
	}

