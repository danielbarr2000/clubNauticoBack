package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Barco;
import com.example.demo.model.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Integer> {
	    List<Salida> findByMatricula_Matricula(String matricula);
}
