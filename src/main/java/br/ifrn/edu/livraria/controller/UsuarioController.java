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

import br.ifrn.edu.livraria.domain.Cidade;
import br.ifrn.edu.livraria.domain.Usuario;
import br.ifrn.edu.livraria.service.CidadeService;
import br.ifrn.edu.livraria.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		return "/usuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("usuarios", usuarioService.buscarTodos());
		return "/usuario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario, RedirectAttributes attr) {
		usuarioService.salvar(usuario);
		attr.addFlashAttribute("success", "Usuario inserido com sucesso.");
		return "redirect:/usuarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", usuarioService.buscarPorId(id));
		return "usuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Usuario usuario, RedirectAttributes attr) {
		usuarioService.editar(usuario);
		attr.addFlashAttribute("success", "Usuario editado com suceusuariosso.");
		return "redirect:/usuarios/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		usuarioService.excluir(id);
		attr.addFlashAttribute("success", "Usuario removido com sucesso.");
		return "redirect:/usuarios/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorTitulo(@RequestParam("nome") String titulo, ModelMap model) {		
		model.addAttribute("usuarios", usuarioService.buscarPorNome(titulo));
		return "/usuario/lista";
	}
	
	@ModelAttribute("cidades")
	public List<Cidade> getCidades() {
		return cidadeService.buscarTodos();
	}
	
}
