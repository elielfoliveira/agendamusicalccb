package br.gov.rj.faetec.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Setor;
import br.gov.rj.faetec.estoque.repository.helper.setor.SetoresQueries;

@Repository
public interface Setores extends JpaRepository<Setor, Long>, SetoresQueries {

}