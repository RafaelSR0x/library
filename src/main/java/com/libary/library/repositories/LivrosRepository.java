package com.libary.library.repositories;

import com.libary.library.entities.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
