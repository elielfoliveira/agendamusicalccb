package br.gov.rj.faetec.estoque.repository.helper.congregacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Congregacao;
import br.gov.rj.faetec.estoque.repository.filter.CongregacaoFilter;

public class CongregacoesImpl implements CongregacoesQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Congregacao> filtrar(CongregacaoFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Congregacao.class);
		
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getEndereco())) {
				criteria.add(Restrictions.ilike("endereco", filtro.getEndereco(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getNumero())) {
				criteria.add(Restrictions.like("numero", filtro.getNumero(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getBairro())) {
				criteria.add(Restrictions.ilike("bairro", filtro.getBairro(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getCidade())) {
				criteria.add(Restrictions.ilike("cidade", filtro.getCidade(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getUf())) {
				criteria.add(Restrictions.ilike("uf", filtro.getUf(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getCep())) {
				criteria.add(Restrictions.ilike("cep", filtro.getCep(), MatchMode.ANYWHERE));
			}
		}
			
		return criteria.list();
	}
}
