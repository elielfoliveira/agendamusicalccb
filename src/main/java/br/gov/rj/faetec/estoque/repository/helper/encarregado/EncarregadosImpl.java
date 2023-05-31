package br.gov.rj.faetec.estoque.repository.helper.encarregado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Encarregado;
import br.gov.rj.faetec.estoque.repository.filter.EncarregadoFilter;

public class EncarregadosImpl implements EncarregadosQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Encarregado> filtrar(EncarregadoFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Encarregado.class);
		
		if (filtro != null) {
						
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getTelefone())) {
				criteria.add(Restrictions.eq("telefone", filtro.getTelefone()));
			}
			
			if (!StringUtils.isEmpty(filtro.getStatus())) {
				criteria.add(Restrictions.eq("status", filtro.getStatus()));
			}
		}
		
		return criteria.list();
	}

}
