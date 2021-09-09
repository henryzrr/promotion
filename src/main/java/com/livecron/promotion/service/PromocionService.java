package com.livecron.promotion.service;

import com.livecron.promotion.model.Cliente;
import com.livecron.promotion.model.Promocion;
import com.livecron.promotion.repository.PromocionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PromocionService {
    private final PromocionRepository repository;
    private final ClienteService clienteService;
    private final EmailServiceImpl emailService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${discount}")
    private String discountPromotion;


    public void notifyPromotionToBirthdayPerson(){
        List<Cliente> clientes = clienteService.findBirthdayPerson();

        String descripcion = getDescripcionPromocion();
        String formatedDescription ;

        for (Cliente cliente : clientes) {
            formatedDescription = formatearDescripcionParaCliente(descripcion,cliente);
            logger.info(formatedDescription);
            System.out.println(formatedDescription);
            emailService.sendSimpleMessage(cliente.getEmail(), "Discount " + discountPromotion + "%", formatedDescription);
        }
    }

    private String getDescripcionPromocion() {
        Promocion promocion = repository.findById(1L).get();
        return promocion.getDescripcion();
    }

    private String formatearDescripcionParaCliente(String descripcion, Cliente cliente) {
        descripcion = descripcion.replace("<name>", cliente.getNombre());
        descripcion = descripcion.replace("<discountValue>", discountPromotion);
        return descripcion;
    }

}
