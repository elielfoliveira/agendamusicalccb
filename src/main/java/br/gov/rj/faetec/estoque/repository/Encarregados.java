package br.gov.rj.faetec.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Encarregado;
import br.gov.rj.faetec.estoque.repository.helper.encarregado.EncarregadosQueries;

@Repository
public interface Encarregados extends JpaRepository<Encarregado, Long>, EncarregadosQueries {

}
