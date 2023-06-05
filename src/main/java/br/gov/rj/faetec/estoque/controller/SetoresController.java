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

import br.gov.rj.faetec.estoque.model.Setor;
import br.gov.rj.faetec.estoque.repository.Setores;
import br.gov.rj.faetec.estoque.repository.filter.SetorFilter;
import br.gov.rj.faetec.estoque.service.CadastroSetorService;

@Controller
@RequestMapping("/setores")
public class SetoresController {

	@Autowired
	private CadastroSetorService cadastroSetorService;
	
	@Autowired
	private Setores setores;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Setor setor) {
		ModelAndView mv = new ModelAndView("setor/CadastroSetor");
		return mv;
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Setor setor, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(setor);
		}
		
		cadastroSetorService.salvar(setor);
		attributes.addFlashAttribute("mensagem", "Setor salvo com sucesso!");
		return new ModelAndView("redirect:/setores/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(SetorFilter setorFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("setor/PesquisaSetores");
		
		mv.addObject("setores", setores.filtrar(setorFilter));
		return mv;
	}
	
}
