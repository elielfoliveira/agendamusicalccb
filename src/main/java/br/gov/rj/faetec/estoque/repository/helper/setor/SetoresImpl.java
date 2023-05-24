package br.gov.rj.faetec.estoque.repository.helper.setor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Setor;
import br.gov.rj.faetec.estoque.repository.filter.SetorFilter;

public class SetoresImpl implements SetoresQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Setor> filtrar(SetorFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Setor.class);
		
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getLocal())) {
				criteria.add(Restrictions.ilike("local", filtro.getLocal(), MatchMode.ANYWHERE));
			}
		}
		
		return criteria.list();
	}

}
