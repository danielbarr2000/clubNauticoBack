package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Salida;

public interface SalidaRepository extends JpaRepository<Salida, Integer> {
}
