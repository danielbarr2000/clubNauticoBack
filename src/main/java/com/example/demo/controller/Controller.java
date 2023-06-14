package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BarcoDTO;
import com.example.demo.dto.SalidaDTO;
import com.example.demo.dto.SocioDTO;
import com.example.demo.model.Barco;
import com.example.demo.model.Salida;
import com.example.demo.model.Socio;
import com.example.demo.repository.BarcoRepository;
import com.example.demo.repository.SalidaRepository;
import com.example.demo.repository.SocioRepository;
import com.example.demo.service.BarcoService;
import com.example.demo.service.SalidaService;
import com.example.demo.service.SocioService;

@RestController
public class Controller {

	@Autowired
	SocioService socioService;
	SocioRepository socioRepository;

	@Autowired
	BarcoService barcoService;
	BarcoRepository barcoRepository;

	@Autowired
	SalidaService salidaService;
	SalidaRepository salidaRepository;

	
	
	// Metodos para los socios-----------------------------------------------------
	
	//GET ALL
	@GetMapping("/socios/get")
	public List<Socio> getAllSocios() {
		return socioService.getAllSocios();
	}

	//GET BY ID
	@GetMapping("/socios/get/{id}")
	public Socio getSocioById(@PathVariable Integer id) {
		return socioService.getSocioById(id);
	}
	
	//GET SOCIO BY USERNAME
	@GetMapping("/socios/get/nombre/{nombre}")
	public Socio getSocioByNombre(@PathVariable String nombre) {
		return socioService.getSocioByNombre(nombre);
	}
	
	@PostMapping("/socios/auth")
	public boolean comprobarExistenciaSocio(@RequestBody Map<String, String> request) {
		String nombre = request.get("nombre");
		String clave = request.get("clave");
        return socioService.comprobarExistenciaSocio(nombre, clave);
        
    }
	
	//POST
	@PostMapping("/socios/post")
	public Socio postSocio(@RequestBody SocioDTO socioDTO) {
		return socioService.postSocio(socioDTO);
	}
	
	//DELETE
	@DeleteMapping("/socios/delete/{id}")
	public Socio deleteSocio(@PathVariable Integer id) {
		return socioService.deleteSocio(id);
	}
	
	//UPDATE
	@PutMapping("/socios/update/{id}")
	public Socio updateSocio(@PathVariable Integer id, @RequestBody SocioDTO socioDTO) {
		return socioService.updateSocio(socioDTO, id);
	}

	
	
	// Metodos para los barcos-----------------------------------------------------
	
	//GET ALL
	@GetMapping("/barcos/get")
	public List<Barco> getAllBarcos() {
		return barcoService.getAllBarcos();
	}

	//GET BY ID
	@GetMapping("/barcos/get/{matricula}")
	public Barco getBarcoByMatricula(@PathVariable String matricula) {
		return barcoService.getBarcoByMatricula(matricula);
	}
	
	//GET BARCOS BY IDSOCIO
	@GetMapping("/barcos/get/user/{idSocio}")
	public ResponseEntity<List<Barco>> obtenerBarcosPorIdSocio(@PathVariable int idSocio) {
        List<Barco> barcos = barcoService.buscarPorIdSocio(idSocio);
        if (barcos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(barcos, HttpStatus.OK);
        }
    }

	//POST
	@PostMapping("/barcos/post")
	public Barco postBarco(@RequestBody BarcoDTO barcoDTO) {
		return barcoService.postBarco(barcoDTO);
	}
	
	//DELETE
	@DeleteMapping("/barcos/delete/{matricula}")
	public Barco deleteBarco(@PathVariable String matricula) {
		return barcoService.deleteBarco(matricula);
	}

	//UPDATE
	@PutMapping("/barcos/update/{matricula}")
	public Barco updateBarco(@PathVariable String matricula, @RequestBody BarcoDTO barcoDTO) {
		return barcoService.updateBarco(barcoDTO, matricula);
	}
	

	
	// Metodos para las salidas-----------------------------------------------------
	
	//GET ALL
	@GetMapping("/salidas/get")
	public List<Salida> getAllSalidas() {
		return salidaService.getAllSalidas();
	}

	//GET BY ID
	@GetMapping("/salidas/get/{id}")
	public Salida getSalidaById(@PathVariable Integer id) {
		return salidaService.getSalidaById(id);
	}
	
	@GetMapping("/salidas/get/matricula/{matricula}")
    public List<Salida> obtenerSalidasPorMatricula(@PathVariable("matricula") String matricula) {
        return salidaService.obtenerSalidasPorMatricula(matricula);
    }
	
	@GetMapping("/salidas/get/usuario/{usuarioId}")
	public List<Salida> obtenerSalidasDeBarcosAsignadosAUsuario(@PathVariable Integer usuarioId) {
        return salidaService.obtenerSalidasDeBarcosAsignadosAUsuario(usuarioId);
    }
	
	//POST
	@PostMapping("/salidas/post")
	public Salida postSalida(@RequestBody SalidaDTO salidaDTO) {
		return salidaService.postSalida(salidaDTO);
	}
	//DELETE
	@DeleteMapping("/salidas/delete/{id}")
	public Salida deleteSalida(@PathVariable Integer id) {
		return salidaService.deleteSalida(id);
	}
	
	//UPDATE
	@PutMapping("/salidas/update/{id}")
	public Salida updateSalida(@PathVariable Integer id, @RequestBody SalidaDTO salidaDTO) {
		return salidaService.updateSalida(salidaDTO, id);
	}
}
