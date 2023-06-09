package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Socio;


public interface SocioRepository extends JpaRepository<Socio, Integer> {

}
