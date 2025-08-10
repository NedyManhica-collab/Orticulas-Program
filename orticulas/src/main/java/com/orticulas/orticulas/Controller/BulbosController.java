package com.orticulas.orticulas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orticulas.orticulas.Service.BulbosService;
import com.orticulas.orticulas.modelClass.Bulbos;

@Controller
@RequestMapping("/bulbos")
public class BulbosController {

    @Autowired
   private BulbosService bulbosService;
   
//Este método é responsável por listar os bulbos, podendo filtrar por nome popular ou científico.
//Caso o parâmetro "nome" seja fornecido, ele busca os bulbos que contêm esse nome em qualquer um dos campos.
//Se o parâmetro não for fornecido, ele lista todos os bulbos disponíveis.
    @GetMapping("/listar")
    public String listarBulbos(@RequestParam(value = "nome", required = false) String nome, Model model){
        if(nome != null && !nome.isEmpty()){
            model.addAttribute("bulbos", bulbosService.buscar(nome));
        }else{
            model.addAttribute("bulbos", bulbosService.listarBulbos());
        }
        model.addAttribute("nome", nome);
        return "bulbos/bulbos";
       
    }
//Este método é responsável por exibir o formulário de registro de bulbos.
    @GetMapping("/Registrar")
    public String registrarBulbos(Model model){
        model.addAttribute("bulbos", new Bulbos());
        return "bulbos/registrarBulbos";
    }
//Este método processa o registro de um novo bulbo.
//use essa requisição para salvar um bulbo no banco de dados no html
    @PostMapping("/salvar")
    public String salvarBulbos(Bulbos bulbos, Model model){
        try {
            bulbosService.salvar(bulbos);
            model.addAttribute("mensagem", "Bulbo salvo com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagem", e.getMessage());
        }
        return "bulbos/Bulbos";
    }
// Exibe o formulário de edição
//aqui voce recebe o formulário de edição do bulbo com os respectivos dados para depos chamar o method atualizarBulbo
@GetMapping("/editar")
public String editarBulbo(@RequestParam("id") Long id, Model model) {
    Bulbos bulbo = bulbosService.buscarPorId(id);
    model.addAttribute("bulbos", bulbo);
    return "bulbos/editarBulbo";
}

// Processa a atualização e Actlualiza o bulbo no banco de dados
@PostMapping("/atualizar")
public String atualizarBulbo(@RequestParam("id") Long id, Bulbos bulbos, Model model) {
    try {
        bulbosService.atualizar(id, bulbos);
        model.addAttribute("mensagem", "Bulbo atualizado com sucesso!");
    } catch (IllegalArgumentException e) {
        model.addAttribute("mensagem", e.getMessage());
    }
    return "redirect:/bulbos/bulbos";
}
}
