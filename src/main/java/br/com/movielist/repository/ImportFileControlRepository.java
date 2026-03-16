package br.com.movielist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movielist.entity.ImportFileControl;

@Repository
public interface ImportFileControlRepository extends JpaRepository<ImportFileControl, Long> {

    boolean existsByHashCode(String hashCode);
    
}