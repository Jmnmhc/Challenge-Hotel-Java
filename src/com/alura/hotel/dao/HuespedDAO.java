package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reserva;

public class HuespedDAO {
	
    private Connection con;

    public HuespedDAO(Connection con) {
        this.con = con;
    }
    
    public void guardar(Huesped huesped, Reserva reserva) {
        
    	System.out.println("ESTE ES EL METODO GUARDAR DE HUESPED");
    	try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO HUESPEDES "
                        + "(nombre, apellido, fecha_Nacimiento, nacionalidad, telefono)"
                        + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, huesped.getNombre());
                statement.setString(2, huesped.getApellido());
                statement.setString(3, huesped.getFechaNacimiento());
                statement.setString(4, huesped.getNacionalidad());
                statement.setString(5, huesped.getTelefono());
                
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        huesped.setId(resultSet.getInt(1));
                        
                        System.out.println(String.format("Fue insertado el huesped: %s", huesped));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    	
    	
    	
    	
    	try {
            PreparedStatement statement2;
                statement2 = con.prepareStatement(
                        "INSERT INTO RESERVAS "
                        + "(id, fecha_entrada, fecha_salida, valor, forma_Pago, id_huesped)"
                        + " VALUES (?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
    
            try (statement2) {
                statement2.setString(1, reserva.getId());
                statement2.setString(2, reserva.getFechaEntrada());
                statement2.setString(3, reserva.getFechaSalida());
                statement2.setInt(4, reserva.getValor());
                statement2.setString(5, reserva.getFomaPago());
                statement2.setInt(6, huesped.getId());//reserva.getIdHuesped());
                
    
                statement2.execute();
    
                final ResultSet resultSet = statement2.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        huesped.setId(resultSet.getInt(1));
                        
                        System.out.println(String.format("Fue insertado el huesped: %s", huesped));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    	
    }

    	
    	

    	   public List<Huesped> listar() {
    	        List<Huesped> resultado = new ArrayList<>();

    	        try {
    	            final PreparedStatement statement = con
    	                    .prepareStatement("SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO , NACIONALIDAD, TELEFONO FROM HUESPEDES");
    	    
    	            try (statement) {
    	                statement.execute();
    	    
    	                final ResultSet resultSet = statement.getResultSet();
    	    
    	                try (resultSet) {
    	                    while (resultSet.next()) {
    	                        resultado.add(new Huesped(
    	                                resultSet.getInt("ID"),
    	                                resultSet.getString("NOMBRE"),
    	                                resultSet.getString("APELLIDO"),
    	                                resultSet.getDate("FECHA_NACIMIENTO"),
    	                                resultSet.getString("NACIONALIDAD"),
    	                                resultSet.getString("TELEFONO")));
    	                    }
    	                }
    	            }
    	        } catch (SQLException e) {
    	            throw new RuntimeException(e);
    	        }

    	        
    	        
    	        return resultado;
    	    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
	
//}
