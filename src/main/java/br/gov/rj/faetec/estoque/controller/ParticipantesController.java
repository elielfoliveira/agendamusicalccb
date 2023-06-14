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

import br.gov.rj.faetec.estoque.model.Participante;
import br.gov.rj.faetec.estoque.model.Origem;
import br.gov.rj.faetec.estoque.model.Sabor;
import br.gov.rj.faetec.estoque.repository.Participantes;
import br.gov.rj.faetec.estoque.repository.Tipos;
import br.gov.rj.faetec.estoque.repository.filter.ParticipanteFilter;
import br.gov.rj.faetec.estoque.service.CadastroParticipanteService;
@Controller
@RequestMapping("/participantes")
public class ParticipantesController {

	@Autowired
	private Tipos tipos;

	@Autowired
	private CadastroParticipanteService cadastroParticipanteService;
	
	@Autowired
	private Participantes participantes;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Participante participante) {
		ModelAndView mv = new ModelAndView("participante/CadastroParticipante");
		//mv.addObject("sabores", Sabor.values());
		mv.addObject("tipos", tipos.findAll()); // Retorna uma lista
		//mv.addObject("origens", Origem.values()); // Retorna um array
		return mv;
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Participante participante, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(participante);
		}
		
		cadastroParticipanteService.salvar(participante);
		attributes.addFlashAttribute("mensagem", "Participante salvo com sucesso!");
		return new ModelAndView("redirect:/participantes/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ParticipanteFilter participanteFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("participante/PesquisaParticipantes");
		mv.addObject("tipos", tipos.findAll());
		//mv.addObject("sabores", Sabor.values());
		//mv.addObject("origens", Origem.values());
		
		mv.addObject("participantes", participantes.filtrar(participanteFilter));
		return mv;
	}
	
}
