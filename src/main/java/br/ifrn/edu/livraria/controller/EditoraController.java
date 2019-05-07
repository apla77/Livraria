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
import br.ifrn.edu.livraria.domain.Editora;
import br.ifrn.edu.livraria.service.AutorService;
import br.ifrn.edu.livraria.service.EditoraService;

@Controller
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraService editoraService;

	@GetMapping("/cadastrar")
	public String cadastrar(Editora editora) {
		return "/editora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("editoras", editoraService.buscarTodos());
		return "/editora/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Editora editora, RedirectAttributes attr) {
		editoraService.salvar(editora);
		attr.addFlashAttribute("success", "Editora inserido com sucesso.");
		return "redirect:/editoras/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("editora", editoraService.buscarPorId(id));
		return "editora/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Editora editora, RedirectAttributes attr) {
		editoraService.editar(editora);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/editoras/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (editoraService.editoraTemLivros(id)) {
			attr.addFlashAttribute("fail", "Editora não excluida. Tem livro(s) vinculado(s).");
		} else {
			editoraService.excluir(id);
			attr.addFlashAttribute("success", "Editora excluida com sucesso.");
		}
		return "redirect:/editoras/listar";
	}
	
	@ModelAttribute("editoras")
	public List<Editora> listaDeEditoras() {
		return editoraService.buscarTodos();
	}	
}
