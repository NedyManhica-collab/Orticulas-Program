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

    @GetMapping("/Bulbod")
    public String listarBulbos(@RequestParam(value = "nome", required = false) String nome, Model model){
        if(nome != null && !nome.isEmpty()){
            model.addAttribute("bulbos", bulbosService.buscar(nome));
        }else{
            model.addAttribute("bulbos", bulbosService.listarBulbos());
        }
        model.addAttribute("nome", nome);
        return "bulbos/bulbos";
       
    }
    @GetMapping("/Registrar")
    public String registrarBulbos(Model model){
        model.addAttribute("bulbos", new Bulbos());
        return "bulbos/registrarBulbos";
    }
    @PostMapping("/salvar")
    public String salvarBulbos(Bulbos bulbos, Model model){
        try {
            bulbosService.salvar(bulbos);
            model.addAttribute("mensagem", "Bulbo salvo com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagem", e.getMessage());
        }
        return "redirect:/bulbos/Bulbos";
    }
}
