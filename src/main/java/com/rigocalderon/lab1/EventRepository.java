package com.rigocalderon.lab1;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Lock(LockModeType.READ)
    @Query("""
        SELECT e FROM Event  e WHERE id = :id
    """)
    Optional<Event> findByIdWithOptimistic(@Param("id") long id);

    @Modifying
    @Query("""
        UPDATE Event SET availableStock = availableStock - 1
        WHERE  id = :id
    """)
    int actualizarEspaciosDisponibles(@Param("id") Long id);
}
