package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalidaDTO;
import com.example.demo.model.Salida;
import com.example.demo.repository.BarcoRepository;
import com.example.demo.repository.SalidaRepository;

@Service
public class SalidaService {
	
	@Autowired
	SalidaRepository salidaRepository;
	
	@Autowired
	BarcoRepository barcoRepository;
	
	@Autowired
	BarcoService barcoService;
	
	//Metodos
	public List<Salida> getAllSalidas(){
		return salidaRepository.findAll();
	}
	
	public Salida getSalidaById(Integer id) {
		return salidaRepository.findById(id).orElse(null);
	}
	
	public Salida postSalida(SalidaDTO salidaDTO) {
		Salida salida = new Salida();
		
		salida.setId_salida(salidaDTO.getId_salida());
		salida.setFecha(salidaDTO.getFecha());
		salida.setDestino(salidaDTO.getDestino());
		salida.setNombre_patron(salidaDTO.getNombre_patron());
		salida.setMatricula_barco(barcoService.getBarcoByMatricula(salidaDTO.getMatricula_barco()));
			
		salidaRepository.save(salida);
		return salida;
	}
	
	public Salida deleteSalida(int id) {
		Salida salidaDelete = getSalidaById(id);
		salidaRepository.delete(salidaDelete);
		return salidaDelete;
	}
	
	public Salida updateSalida(SalidaDTO salidaDTO, int id) {
		Salida salida = getSalidaById(id);
		
		salida.setId_salida(id);
		salida.setFecha(salidaDTO.getFecha());
		salida.setDestino(salidaDTO.getDestino());
		salida.setNombre_patron(salidaDTO.getNombre_patron());
		salida.setMatricula_barco(barcoService.getBarcoByMatricula(salidaDTO.getMatricula_barco()));
		
		salidaRepository.save(salida);
		return salida;
	}
}