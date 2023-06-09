package com.example.demo.dto;

import com.example.demo.model.*;
import java.util.List;
import java.util.ArrayList;

public class BarcoDTO{

	// Atributos---------------------------
	private String matricula;
	
	private String nombre;
	
	private int n_amarre;
	
	private double cuota;

	private int idSocio;
	
	
	
	public BarcoDTO() {
		// TODO Auto-generated constructor stub
	}


	public BarcoDTO(String matricula, String nombre, int n_amarre, double cuota, int idSocio) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.n_amarre = n_amarre;
		this.cuota = cuota;
		this.idSocio = idSocio;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getN_amarre() {
		return n_amarre;
	}


	public void setN_amarre(int n_amarre) {
		this.n_amarre = n_amarre;
	}


	public double getCuota() {
		return cuota;
	}


	public void setCuota(double cuota) {
		this.cuota = cuota;
	}


	public int getIdSocio() {
		return idSocio;
	}


	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
}
