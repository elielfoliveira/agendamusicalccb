package br.gov.rj.faetec.estoque.repository.helper.regional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Produto;
import br.gov.rj.faetec.estoque.repository.filter.ProdutoFilter;

public class RegionaisImpl implements RegionaisQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Regional> filtrar(RegionalFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Regional.class);
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if (filtro != null) {
				if (!StringUtils.isEmpty(filtro.getTelefone())) {
					criteria.add(Restrictions.eq("telefone", filtro.getTelefone()));
				}
				
			if (filtro != null) {
				if (!StringUtils.isEmpty(filtro.getStatus())) {
						criteria.add(Restrictions.eq("status", filtro.getStatus()));
				}
		}
		
		return criteria.list();
	}
	
	private boolean isEstiloPresente(ProdutoFilter filtro) {
		return filtro.getEstilo() != null && filtro.getEstilo().getCodigo() != null;
	}

}
