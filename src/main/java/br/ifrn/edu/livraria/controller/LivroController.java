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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifrn.edu.livraria.domain.Autor;
import br.ifrn.edu.livraria.domain.Categoria;
import br.ifrn.edu.livraria.domain.Editora;
import br.ifrn.edu.livraria.domain.Livro;
import br.ifrn.edu.livraria.service.AutorService;
import br.ifrn.edu.livraria.service.CategoriaService;
import br.ifrn.edu.livraria.service.EditoraService;
import br.ifrn.edu.livraria.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private EditoraService editoraService;

	@GetMapping("/cadastrar")
	public String cadastrar(Livro livro) {
		return "/livro/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("livros", livroService.buscarTodos());
		return "/livro/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Livro livro, RedirectAttributes attr) {
		livroService.salvar(livro);
		attr.addFlashAttribute("success", "Livro inserido com sucesso.");
		return "redirect:/livros/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("livro", livroService.buscarPorId(id));
		return "livro/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Livro livro, RedirectAttributes attr) {
		livroService.editar(livro);
		attr.addFlashAttribute("success", "Livro editado com sucesso.");
		return "redirect:/livros/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		livroService.excluir(id);
		attr.addFlashAttribute("success", "Livro removido com sucesso.");
		return "redirect:/livros/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorTitulo(@RequestParam("titulo") String titulo, ModelMap model) {		
		model.addAttribute("livros", livroService.buscarPorTitulo(titulo));
		return "/livro/lista";
	}
	
	@ModelAttribute("categorias")
	public List<Livro> listaDeLivros() {
		return livroService.buscarTodos();
	}	
	
		
	@ModelAttribute("autores")
	public List<Autor> getAutores() {
		return autorService.buscarTodos();
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias() {
		return categoriaService.buscarTodos();
	}
	
	@ModelAttribute("editoras")
	public List<Editora> getEditoras() {
		return editoraService.buscarTodos();
	}
	
}
