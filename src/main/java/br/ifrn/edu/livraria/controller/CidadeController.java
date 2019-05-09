package br.ifrn.edu.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifrn.edu.livraria.domain.UF;

import br.ifrn.edu.livraria.domain.Autor;
import br.ifrn.edu.livraria.domain.Cidade;
import br.ifrn.edu.livraria.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cidade cidade) {
		return "/cidade/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cidades", cidadeService.buscarTodos());
		return "/cidade/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Cidade cidade, RedirectAttributes attr) {
		cidadeService.salvar(cidade);
		attr.addFlashAttribute("success", "Cidade inserida com sucesso.");
		return "redirect:/cidades/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cidade", cidadeService.buscarPorId(id));
		return "cidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cidade cidade, RedirectAttributes attr) {
		cidadeService.editar(cidade);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/cidades/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (cidadeService.cidadeTemUsuarios(id)) {
			attr.addFlashAttribute("fail", "Cidade não excluida. Tem estado vinculado.");
		} else {
			cidadeService.excluir(id);
			attr.addFlashAttribute("success", "Cidade excluida com sucesso.");
		}
		return "redirect:/cidades/listar";
	}
	
	@ModelAttribute("cidades")
	public List<Cidade> listaDeCidades() {
		return cidadeService.buscarTodos();
	}	
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
