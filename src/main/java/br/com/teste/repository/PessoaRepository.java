package br.com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
