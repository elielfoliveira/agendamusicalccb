package br.gov.rj.faetec.estoque.repository.helper.participante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Participante;
import br.gov.rj.faetec.estoque.repository.filter.ParticipanteFilter;
import br.gov.rj.faetec.estoque.repository.filter.ProdutoFilter;

public class ParticipantesImpl implements ParticipantesQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Participante> filtrar(ParticipanteFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Participante.class);
		
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if (filtro.getDtnascimento() != null) {
			    criteria.add(Restrictions.eq("dtnascimento", filtro.getDtnascimento()));
			}
			
			if (!StringUtils.isEmpty(filtro.getEmail())) {
				criteria.add(Restrictions.ilike("email", filtro.getEmail(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getCelular())) {
				criteria.add(Restrictions.ilike("celular", filtro.getCelular(), MatchMode.ANYWHERE));
			}
			
			if (filtro.getDtcadastro() != null) {
			    criteria.add(Restrictions.eq("dtcadastro", filtro.getDtcadastro()));
			}

		}
		
		return criteria.list();
	}
	
	private boolean isTipoPresente(ParticipanteFilter filtro) {
		return filtro.getTipo() != null && filtro.getTipo().getId() != null;
	}

}
