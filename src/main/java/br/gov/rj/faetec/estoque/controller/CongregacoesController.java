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

import br.gov.rj.faetec.estoque.model.Congregacao;
import br.gov.rj.faetec.estoque.repository.Congregacoes;
import br.gov.rj.faetec.estoque.repository.filter.CongregacaoFilter;
import br.gov.rj.faetec.estoque.service.CadastroCongregacaoService;

@Controller
@RequestMapping("/congregacoes")
public class CongregacoesController {

	@Autowired
	private CadastroCongregacaoService cadastroCongregacaoService;
	
	@Autowired
	private Congregacoes congregacoes;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Congregacao congregacao) {
		ModelAndView mv = new ModelAndView("congregacao/CadastroCongregacao");
		return mv;
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Congregacao congregacao, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(congregacao);
		}
		
		cadastroCongregacaoService.salvar(congregacao);
		attributes.addFlashAttribute("mensagem", "Congregação salva com sucesso!");
		return new ModelAndView("redirect:/congregacoes/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(CongregacaoFilter congregacaoFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("congregacao/PesquisaCongregacoes");
		
		mv.addObject("congregacoes", congregacoes.filtrar(congregacaoFilter));
		return mv;
	}
	
}
