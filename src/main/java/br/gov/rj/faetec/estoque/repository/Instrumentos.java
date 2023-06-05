package br.gov.rj.faetec.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Instrumento;
import br.gov.rj.faetec.estoque.repository.helper.instrumento.InstrumentosQueries;

@Repository
public interface Instrumentos extends JpaRepository<Instrumento, Long>, InstrumentosQueries {

}