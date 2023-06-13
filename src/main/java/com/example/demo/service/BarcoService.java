package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BarcoDTO;
import com.example.demo.model.Barco;
import com.example.demo.model.Socio;
import com.example.demo.repository.BarcoRepository;
import com.example.demo.repository.SocioRepository;

@Service
public class BarcoService {

	@Autowired
	BarcoRepository barcoRepository;

	@Autowired
	SocioRepository socioRepository;
	
	@Autowired
	SocioService socioService;

	public List<Barco> getAllBarcos() {
		return barcoRepository.findAll();
	}

	public Barco getBarcoByMatricula(String matricula) {
		return barcoRepository.findById(matricula).orElse(null);
	}
	
	public List<Barco> buscarPorIdSocio(int idSocio) {
        return barcoRepository.findBySocioIdSocio(idSocio);
    }

	public Barco deleteBarco(String matricula) {
		Barco barcoDelete = getBarcoByMatricula(matricula);
		barcoRepository.delete(barcoDelete);
		return barcoDelete;
	}

	public Barco updateBarco(BarcoDTO barcoDTO, String matricula) {
		Barco barco = getBarcoByMatricula(matricula);
		Socio socio = socioService.getSocioById(barcoDTO.getIdSocio());
		
		barco.setMatricula(matricula);
		barco.setSocio(socio);
		barco.setNombre(barcoDTO.getNombre());
		barco.setN_amarre(barcoDTO.getN_amarre());
		barco.setCuota(barcoDTO.getCuota());
		
		barcoRepository.save(barco);
		return barco;
	}
	
	public Barco postBarco(BarcoDTO barcoDTO) {
		Barco barco = new Barco();
		
		barco.setMatricula(barcoDTO.getMatricula());
		barco.setNombre(barcoDTO.getNombre());
		barco.setN_amarre(barcoDTO.getN_amarre());
		barco.setCuota(barcoDTO.getCuota());
		barco.setSocio(socioService.getSocioById(barcoDTO.getIdSocio()));
		
		barcoRepository.save(barco);
		return barco;
	}
}
