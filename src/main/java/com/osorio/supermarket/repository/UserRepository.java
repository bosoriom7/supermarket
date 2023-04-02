package com.osorio.supermarket.repository;

import com.osorio.supermarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Las interfaces deben extender de la interfaz JpaRepository<Clase, tipo identificador>
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
