package com.livecron.promotion;

import com.livecron.promotion.model.Cliente;
import com.livecron.promotion.model.Promocion;
import com.livecron.promotion.repository.ClienteRepository;
import com.livecron.promotion.repository.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PromotionApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(PromotionApplication.class, args);
    }

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PromocionRepository promocionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Cliente cliente = Cliente.builder()
                .email("henry.zrz@gmail.com")
                .diaNacimiento(9)
                .mesNacimiento(9)
                .nombre("henry zr")
                .build();
        clienteRepository.save(cliente);

        cliente = Cliente.builder()
                .email("andres.hernandes@gmail.com")
                .diaNacimiento(19)
                .mesNacimiento(9)
                .nombre("andres hernandes")
                .build();
        clienteRepository.save(cliente);

        Promocion promocion = Promocion.builder()
                .descripcion("<name> Hoy es su cumpleaños y usted es importante para nosotros, queremos celebralo ofreciendo un <discountValue>% de descuento y delivery gratuito. Valido por 24 hrs").build();

        promocionRepository.save(promocion);

    }
}
