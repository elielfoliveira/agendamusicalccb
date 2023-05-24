package br.gov.rj.faetec.estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.rj.faetec.estoque.model.Produto;
import br.gov.rj.faetec.estoque.model.Origem;
import br.gov.rj.faetec.estoque.model.Sabor;
import br.gov.rj.faetec.estoque.repository.Produtos;
import br.gov.rj.faetec.estoque.repository.Estilos;
import br.gov.rj.faetec.estoque.repository.filter.ProdutoFilter;
import br.gov.rj.faetec.estoque.service.CadastroProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private Estilos estilos;

	@Autowired
	private CadastroProdutoService cadastroProdutoService;
	
	@Autowired
	private Produtos produtos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView mv = new ModelAndView("produto/CadastroProduto");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll()); // Retorna uma lista
		mv.addObject("origens", Origem.values()); // Retorna um array
		return mv;
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		
		cadastroProdutoService.salvar(produto);
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:/produtos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ProdutoFilter produtoFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("produto/PesquisaProdutos");
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());
		
		mv.addObject("produtos", produtos.filtrar(produtoFilter));
		return mv;
	}
	
}
