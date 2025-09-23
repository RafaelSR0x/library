package com.libary.library.repositories;

import com.libary.library.entities.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {
}
