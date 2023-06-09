package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "barcos")
public class Barco{

	// Atributos---------------------------
	@Id
	private String matricula;
	
	private String nombre;
	
	private int n_amarre;
	
	private double cuota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_socio")
	private Socio socio;
	
	@OneToMany(mappedBy = "matricula_barco", cascade = CascadeType.ALL)
	private List<Salida> salidas = new ArrayList<>();

	
	// Constructores-----------------------
	public Barco() {
	}

	

	public Barco(String matricula, String nombre, int n_amarre, double cuota, Socio socio) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.n_amarre = n_amarre;
		this.cuota = cuota;
		this.socio = socio;
	}

	// Getters y Setters------------------
	
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
	
	public int getSocio() {
		return socio.getIdSocio();
	}
	
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public List<Salida> getSalidas() {
		return salidas;
	}
	
	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}


	// ToString-----------------------
	@Override
	public String toString() {
		return "Barco [matricula=" + matricula + ", nombre=" + nombre + ", n_amarre=" + n_amarre + ", cuota=" + cuota
				+ ", socio=" + getSocio() + ", salidas=" + salidas + "]";
	}
	


}
