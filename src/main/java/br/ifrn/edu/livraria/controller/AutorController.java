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

import br.ifrn.edu.livraria.domain.Autor;
import br.ifrn.edu.livraria.domain.Categoria;
import br.ifrn.edu.livraria.service.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService autorService;

	@GetMapping("/cadastrar")
	public String cadastrar(Autor autor) {
		return "/autor/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("autores", autorService.buscarTodos());
		return "/autor/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Autor autor, RedirectAttributes attr) {
		autorService.salvar(autor);
		attr.addFlashAttribute("success", "Autor inserido com sucesso.");
		return "redirect:/autores/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("autor", autorService.buscarPorId(id));
		return "autor/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Autor autor, RedirectAttributes attr) {
		autorService.editar(autor);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/autores/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (autorService.autorTemLivros(id)) {
			attr.addFlashAttribute("fail", "Autor não excluido. Tem livro(s) vinculado(s).");
		} else {
			autorService.excluir(id);
			attr.addFlashAttribute("success", "Ator excluido com sucesso.");
		}
		return "redirect:/autores/listar";
	}
	
	@ModelAttribute("autores")
	public List<Autor> listaDeAutores() {
		return autorService.buscarTodos();
	}	

}
