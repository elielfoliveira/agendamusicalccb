package br.gov.rj.faetec.estoque.repository.helper.participante;

import java.util.List;

import br.gov.rj.faetec.estoque.model.Participante;
import br.gov.rj.faetec.estoque.repository.filter.ParticipanteFilter;

public interface ParticipantesQueries {

	public List<Participante> filtrar(ParticipanteFilter filtro);
	
}
