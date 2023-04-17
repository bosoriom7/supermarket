package com.osorio.supermarket.repository;

import com.osorio.supermarket.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Las interfaces deben extender de la interfaz JpaRepository<Clase, tipo identificador>
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    //select * from purchases where color="rojo";
    @Query("SELECT p FROM Purchase p WHERE p.color = :color")
    Optional<Purchase> findByColor(@Param("color") String color);

    //select * from purchases where color="rojo" and valor="2500";
    Optional<Purchase> findByColorAndValor(String color, int valor);

    //select * from purchases where color="rojo" order by id;
    List<Purchase> findByColorOrderByPurchaseId(String color);
}
