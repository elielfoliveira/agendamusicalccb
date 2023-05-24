package br.gov.rj.faetec.estoque.repository.helper.congregacao;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Congregacao;
import br.gov.rj.faetec.estoque.repository.filter.CongregacaoFilter;

public interface CongregacoesQueries {
	
	public List<Congregacao> filtrar(CongregacaoFilter filtro);

}
