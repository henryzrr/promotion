package com.livecron.promotion.repository;

import com.livecron.promotion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByDiaNacimientoAndMesNacimiento(Integer diaNacimiento, Integer mesNacimiento);

}
