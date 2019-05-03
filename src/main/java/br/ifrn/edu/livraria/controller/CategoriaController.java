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

import br.ifrn.edu.livraria.domain.Categoria;
import br.ifrn.edu.livraria.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
//	@Autowired
//	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Categoria categoria) {
		return "/categoria/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("categorias", categoriaService.buscarTodos());
		return "/categoria/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Categoria categoria, RedirectAttributes attr) {
		categoriaService.salvar(categoria);
		attr.addFlashAttribute("success", "Categoria inserido com sucesso.");
		return "redirect:/categorias/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("categoria", categoriaService.buscarPorId(id));
		return "categoria/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Categoria categoria, RedirectAttributes attr) {
		categoriaService.editar(categoria);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/categorias/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (categoriaService.categoriaTemLivros(id)) {
			attr.addFlashAttribute("fail", "Categoria não excluido. Tem funcionário(s) vinculado(s).");
		} else {
			categoriaService.excluir(id);
			attr.addFlashAttribute("success", "Categoria excluido com sucesso.");
		}
		return "redirect:/categorias/listar";
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> listaDeCategorias() {
		return categoriaService.buscarTodos();
	}	
    
}
