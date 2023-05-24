package br.gov.rj.faetec.estoque.repository.helper.produto;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Produto;
import br.gov.rj.faetec.estoque.repository.filter.ProdutoFilter;

public interface ProdutosQueries {

	public List<Produto> filtrar(ProdutoFilter filtro);
	
}
