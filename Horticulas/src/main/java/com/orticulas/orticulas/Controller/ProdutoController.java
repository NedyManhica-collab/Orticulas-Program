package com.orticulas.orticulas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orticulas.orticulas.Service.ProdutoService;
import com.orticulas.orticulas.modelClass.Produto;



@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public String listarProdutos(@RequestParam(value = "noome", required = false)String nome, Model model){

        List<Produto> lista = (nome != null && !nome.isBlank())
                ? produtoService.buscar(nome)
                : produtoService.listarProdutos();

        model.addAttribute("produtos", lista);
        model.addAttribute("produto", new Produto());
        model.addAttribute("nome", nome);

        return "produtos/produtos";

    }@PostMapping("/salvar")
    public String salvarProduto(Produto produto, Model model)
    {
        try {
            produtoService.salvar(produto);
            model.addAttribute("mensagem", "Produto salvo com sucesso!");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao salvar o produto: " + e.getMessage());
        }
        return "produtos/produtos";

    }
    @GetMapping("/registrar")
    public String registrarProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/registrarProduto";
    }
    @GetMapping("/editar")
    public String editarProduto(@RequestParam("id") Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id);
        model.addAttribute("produto", produto);
        return "produtos/editarProduto";
    }
    @PostMapping("/atualizar")
    public String atualizarProduto(@ModelAttribute("produto") Produto produto, Model model) {
        try {
            produtoService.atualizar(produto.getId(), produto);
            model.addAttribute("mensagem", "Produto atualizado com sucesso!");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao atualizar o produto: " + e.getMessage());
        }
        return "produtos/produtos";
    }    
}
