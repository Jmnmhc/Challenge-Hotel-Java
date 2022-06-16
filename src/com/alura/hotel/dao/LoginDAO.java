package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Empleados;

public class LoginDAO {

    private Connection con;

    public LoginDAO(Connection con) {
        this.con = con;
    }
    
    public List<Empleados> listar() {
        List<Empleados> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT  USER, PASS FROM EMPLEADO");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Empleados(
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
//
//        public List<Producto> listar(Categoria categoria) {
//        List<Producto> resultado = new ArrayList<>();
//
//        try {
//            String sql = "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD "
//            + " FROM PRODUCTO WHERE CATEGORIA_ID = ?";
//            System.out.println(sql);
//            
//            final PreparedStatement statement = con.prepareStatement(
//                    sql);
//    
//            try (statement) {
//                statement.setInt(1, categoria.getId());
//                statement.execute();
//    
//                final ResultSet resultSet = statement.getResultSet();
//    
//                try (resultSet) {
//                    while (resultSet.next()) {
//                        resultado.add(new Producto(
//                                resultSet.getInt("ID"),
//                                resultSet.getString("NOMBRE"),
//                                resultSet.getString("DESCRIPCION"),
//                                resultSet.getInt("CANTIDAD")));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return resultado;
//    }

}
