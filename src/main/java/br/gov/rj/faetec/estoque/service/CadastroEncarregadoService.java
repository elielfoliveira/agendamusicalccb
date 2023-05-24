package br.gov.rj.faetec.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rj.faetec.estoque.model.Encarregado;
import br.gov.rj.faetec.estoque.repository.Encarregados;

@Service  // Trata-se de um Componente @Component, um serviço referente a regras de negócio
public class CadastroEncarregadoService {

	@Autowired  // Indica que será injetado o repositório abaixo
	private Encarregados encarregados; // Repositório de produtos, será necessário para salvar o produto
	
	@Transactional // Abre uma transação quando for iniciar a execução do método salvar
	public void salvar(Encarregado encarregado) {
		encarregados.save(encarregado); // No repositório produtos
	}
	
} // Esta classe CadastroProdutoService deverá ser injetada na classe ProdutosController.java
  // Abra a classe ProdutosController.java e veja a seguinte referência:
  //         @Autowired
  //         private CadastroProdutoService cadastroProdutoService;
  // Com isto será possível indicar na classe ProdutosController o seguinte:
  //         cadastroProdutoService.salvar(produto); (linha 45 de ProdutosController.java)

