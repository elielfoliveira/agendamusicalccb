package br.gov.rj.faetec.estoque.repository.helper.regional;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Produto;
import br.gov.rj.faetec.estoque.repository.filter.ProdutoFilter;

public interface RegionaisQueries {

	public List<Produto> filtrar(ProdutoFilter filtro);
	
}
