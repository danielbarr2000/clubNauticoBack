package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "socios")
public class Socio {
	//Atributos--------------------------
	@Id
	private int idSocio;
	
	private String nombre;
	
	private String telefono;
	
	private String clave;
	
	@OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
	private List<Barco> barcos = new ArrayList<>();
	
	
	//Constructores---------------------
	public Socio() {
	}



	public Socio(int idSocio, String nombre, String telefono, String clave) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.clave = clave;
	}

	
	
	//Getters y Setters--------------------
	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Barco> getBarcos() {
		return barcos;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}
	
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}



	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", nombre=" + nombre + ", telefono=" + telefono + ", clave=" + clave
				+ ", barcos=" + barcos + "]";
		}
	}
