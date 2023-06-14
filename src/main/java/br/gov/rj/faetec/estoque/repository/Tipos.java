package br.gov.rj.faetec.estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Tipo;

@Repository
public interface Tipos extends JpaRepository<Tipo, Long> {

	public Optional<Tipo> findByDescricaoIgnoreCase(String descricao);
	
}
