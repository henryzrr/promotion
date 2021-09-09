package com.livecron.promotion.service;

import com.livecron.promotion.model.Cliente;
import com.livecron.promotion.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> findBirthdayPerson(){
        LocalDate hoy = LocalDate.now();
        Integer diaActual= hoy.getDayOfMonth();
        Integer mesActual= hoy.getMonthValue();
        return repository.findByDiaNacimientoAndMesNacimiento(diaActual,mesActual);
    }
}
