package com.rigocalderon.lab1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Modifying
    @Query("""
        UPDATE Event SET availableStock = availableStock - 1
        WHERE  id = :id AND availableStock > 0
    """)
    int actualizarEspaciosDisponibles(@Param("id") Long id);
}
