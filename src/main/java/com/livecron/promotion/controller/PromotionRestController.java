package com.livecron.promotion.controller;

import com.livecron.promotion.service.PromocionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/promocion")
public class PromotionRestController {

    private final PromocionService promocionService;



    @GetMapping("$birthdate")
    public ResponseEntity<?> sendBirthdayMessage(){
        promocionService.notifyPromotionToBirthdayPerson();
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
