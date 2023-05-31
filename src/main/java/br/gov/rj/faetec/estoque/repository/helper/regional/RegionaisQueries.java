package br.gov.rj.faetec.estoque.repository.helper.regional;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Regional;
import br.gov.rj.faetec.estoque.repository.filter.RegionalFilter;

public interface RegionaisQueries {

	public List<Regional> filtrar(RegionalFilter filtro);
	
}
