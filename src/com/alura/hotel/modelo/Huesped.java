package com.alura.hotel.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Huesped {

	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	
	public Huesped(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}

	public Huesped(String nombre, String apellido, Date fechaNac, String nacionalidad, String telefono) {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
		Date dataFormateada = null;
//		try {
//			dataFormateada = formato.parse(fechaNac);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		this.nombre = nombre;
		this.apellido = apellido;
//		this.fechaNacimiento = dataFormateada;
		this.fechaNacimiento = fechaNac;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;

		
System.out.println("ENTRA AL CONSTRUCTOR");
		
		
	}

	public String getNombre() {
		System.out.println("LLAMA AL GETTER DE NOMBRE");
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento.toString();
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setId(int id) {
		this.id = id;
		
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{ id: %d, nombre: %s, apellido: %s, fecha_nacimiento: %s, nacionalidad: %s, telefono: %s}",
	                this.id, this.nombre, this.apellido, this.fechaNacimiento.toString(), this.nacionalidad, this.telefono);
	       
	    }
}
