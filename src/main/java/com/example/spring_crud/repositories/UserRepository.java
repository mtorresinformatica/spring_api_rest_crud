<<<<<<< HEAD
package com.example.spring_crud.repositories;

import com.example.spring_crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
||||||| parent of e1766a6 (Creación de la configuración de seguridad añadiendo el filtro de autorización del login y generación del token)
=======
package com.example.spring_crud.repositories;

import com.example.spring_crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
>>>>>>> e1766a6 (Creación de la configuración de seguridad añadiendo el filtro de autorización del login y generación del token)
