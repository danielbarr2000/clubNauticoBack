package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SocioDTO;
import com.example.demo.model.Socio;
import com.example.demo.repository.SocioRepository;

@Service
public class SocioService {

	@Autowired
	SocioRepository socioRepository;
	
	//Metodos
	public List<Socio> getAllSocios(){
		return socioRepository.findAll();
	}
	
	public Socio getSocioById(int id) {
		return socioRepository.findById(id).orElse(null);
	}
	
	public Socio deleteSocio(int id) {
		Socio socioDelete = getSocioById(id);
		socioRepository.delete(socioDelete);
		return socioDelete;
	}
	
	public Socio updateSocio(SocioDTO socioDTO, int id) {
		Socio socio = getSocioById(id);
		
		socio.setIdSocio(id);
		socio.setNombre(socioDTO.getNombre());
		socio.setTelefono(socioDTO.getTelefono());
		
		socioRepository.save(socio);
		return socio;
	}
	
	public Socio postSocio(SocioDTO socioDTO) {
		Socio socio = new Socio();
		
		socio.setIdSocio(socioDTO.getIdSocio());
		socio.setNombre(socioDTO.getNombre());
		socio.setTelefono(socioDTO.getTelefono());
		
		socioRepository.save(socio);
		return socio;
	}
}
