package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salidas")
public class Salida {
	
	@Id
	private int id_salida;
	
	private LocalDate fecha;
	
	private String destino;
	
	private String nombre_patron;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricula")
	private Barco matricula;
	
	public Salida() {
	}

	public Salida(int id_salida, LocalDate fecha, String destino, String nombre_patron, Barco matricula) {
		this.id_salida = id_salida;
		this.fecha = fecha;
		this.destino = destino;
		this.nombre_patron = nombre_patron;
		this.matricula = matricula;
	}

	public int getId_salida() {
		return id_salida;
	}

	public void setId_salida(int id_salida) {
		this.id_salida = id_salida;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNombre_patron() {
		return nombre_patron;
	}

	public void setNombre_patron(String nombre_patron) {
		this.nombre_patron = nombre_patron;
	}

	public String getMatricula_barco() {
		return matricula.getMatricula();
	}

	public void setMatricula_barco(Barco matricula_barco) {
		this.matricula = matricula_barco;
	}

	@Override
	public String toString() {
		return "Salida [id_salida=" + id_salida + ", fecha=" + fecha + ", destino=" + destino + ", nombre_patron="
				+ nombre_patron + ", matricula_barco=" + matricula + "]";
	}

	
	
}
