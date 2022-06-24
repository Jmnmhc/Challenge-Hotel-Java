package com.alura.hotel.controller;

import java.util.List;

import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reserva;
import com.alura.hotel.dao.HuespedDAO;

public class HuespedController {
		
    private HuespedDAO huespedDao;
    
    public HuespedController () {
    	var factory = new ConnectionFactory();
    	this.huespedDao = new HuespedDAO(factory.recuperaConexion());
    }
    
    
    public void mensaje(String texto) {
    	
    System.out.println("llamo correctamente al huesped controller, asi que: "+ texto);	
    }
    
    public void guardar (Huesped huesped, Reserva reserva) {
    	System.out.println("guardar del huesped controller");
    	huespedDao.guardar(huesped, reserva);
    }
    
    public List<Huesped> listar() {
        return huespedDao.listar();
    }

    
}
