package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.hotel.modelo.Reserva;

public class ReservaDAO {
	
	private Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reserva reserva) {

		
		
	   	System.out.println("ESTE ES EL METODO GUARDAR DE RESERVA DAO");
    	try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO RESERVAS"
                        + "(fecha_entrada, fecha_salida, valor, forma_pago, id_huesped)"
                        + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, reserva.getFechaEntrada());
                statement.setString(2, reserva.getFechaSalida());
                statement.setInt(3, reserva.getValor());
                statement.setString(4, reserva.getFomaPago());
                statement.setInt(5, reserva.getIdHuesped());
                
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                    //	reserva.setId(resultSet.getInt(1));
                        
                        System.out.println(String.format("Fue insertada la reserva: %s", reserva));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
		
		
	}


