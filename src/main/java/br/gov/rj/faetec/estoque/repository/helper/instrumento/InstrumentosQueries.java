package br.gov.rj.faetec.estoque.repository.helper.instrumento;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Instrumento;
import br.gov.rj.faetec.estoque.repository.filter.InstrumentoFilter;

public interface InstrumentosQueries {
	
	public List<Instrumento> filtrar(InstrumentoFilter instrumentoFilter);

}
