package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Barco;

public interface BarcoRepository extends JpaRepository<Barco, String>{
	List<Barco> findBySocioIdSocio(int idSocio);
}
