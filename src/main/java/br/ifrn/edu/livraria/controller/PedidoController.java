package br.ifrn.edu.livraria.controller;

import java.util.Date;
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

import br.ifrn.edu.livraria.domain.Livro;
import br.ifrn.edu.livraria.domain.Pedido;
import br.ifrn.edu.livraria.service.LivroService;
import br.ifrn.edu.livraria.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private LivroService livroService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pedido pedido) {
		pedido.setDataPedido(new Date());
		return "/pedido/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pedidos", pedidoService.buscarTodos());
		return "/pedido/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Pedido pedido, RedirectAttributes attr) {
		pedidoService.salvar(pedido);
		attr.addFlashAttribute("success", "Pedido inserido com sucesso.");
		return "redirect:/pedidos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedido", pedidoService.buscarPorId(id));
		return "pedido/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Pedido pedido, RedirectAttributes attr) {
		pedidoService.editar(pedido);
		attr.addFlashAttribute("success", "Pedido editado com sucesso.");
		return "redirect:/pedidos/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pedidoService.excluir(id);
		attr.addFlashAttribute("success", "Pedido removido com sucesso.");
		return "redirect:/pedidos/listar";
	}	
	
	@ModelAttribute("livros")
	public List<Livro> listaDeLivros() {
		return livroService.buscarTodos();
	}	

}
