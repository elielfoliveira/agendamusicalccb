package br.gov.rj.faetec.estoque.repository.helper.instrumento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Instrumento;
import br.gov.rj.faetec.estoque.repository.filter.InstrumentoFilter;

public class InstrumentosImpl implements InstrumentosQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Instrumento> filtrar(InstrumentoFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Instrumento.class);
		
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getDescricao())) {
				criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
			}
		}
		
		return criteria.list();
	}

}
