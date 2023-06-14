package br.gov.rj.faetec.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rj.faetec.estoque.model.Participante;
import br.gov.rj.faetec.estoque.repository.helper.participante.ParticipantesQueries;

@Repository
public interface Participantes extends JpaRepository<Participante, Long>, ParticipantesQueries {

}
