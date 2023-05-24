package br.gov.rj.faetec.estoque.repository.helper.setor;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Setor;
import br.gov.rj.faetec.estoque.repository.filter.SetorFilter;

public interface SetoresQueries {
	
	public List<Setor> filtrar(SetorFilter setorFilter);

}
