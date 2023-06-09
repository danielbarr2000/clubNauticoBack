package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Barco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class SocioDTO {

	// Atributos------------------------------
	private int idSocio;
	private String nombre;
	private String telefono;

	// Constructores---------------------
	public SocioDTO() {
	}

	public SocioDTO(int idSocio, String nombre, String telefono) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	// Getters y Setters--------------------
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
}
