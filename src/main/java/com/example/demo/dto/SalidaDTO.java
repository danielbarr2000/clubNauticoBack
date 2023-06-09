package com.example.demo.dto;

import java.time.LocalDate;

public class SalidaDTO {
	
	private int id_salida;
	private LocalDate fecha;
	private String destino;
	private String nombre_patron;
	private String matricula_barco;
	
	public SalidaDTO() {
	}

	public SalidaDTO(int id_salida, LocalDate fecha, String destino, String nombre_patron, String matricula_barco) {
		this.id_salida = id_salida;
		this.fecha = fecha;
		this.destino = destino;
		this.nombre_patron = nombre_patron;
		this.matricula_barco = matricula_barco;
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
		return matricula_barco;
	}

	public void setMatricula_barco(String matricula_barco) {
		this.matricula_barco = matricula_barco;
	}
}
