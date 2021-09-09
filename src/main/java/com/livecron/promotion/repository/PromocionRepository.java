package com.livecron.promotion.repository;

import com.livecron.promotion.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {

    Optional<Promocion> findById(Long id);
}
