package br.gov.rj.faetec.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Congregacao;
import br.gov.rj.faetec.estoque.repository.helper.congregacao.CongregacoesQueries;

@Repository
public interface Congregacoes extends JpaRepository<Congregacao, Long>, CongregacoesQueries {

}