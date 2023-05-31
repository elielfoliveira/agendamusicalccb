package br.gov.rj.faetec.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Regional;
import br.gov.rj.faetec.estoque.repository.helper.regional.RegionaisQueries;

@Repository
public interface Regionais extends JpaRepository<Regional, Long>, RegionaisQueries {

}
