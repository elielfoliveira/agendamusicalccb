package br.gov.rj.faetec.estoque.repository.helper.encarregado;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Encarregado;
import br.gov.rj.faetec.estoque.repository.filter.EncarregadoFilter;

public interface EncarregadosQueries {

	public List<Encarregado> filtrar(EncarregadoFilter filtro);
	
}
