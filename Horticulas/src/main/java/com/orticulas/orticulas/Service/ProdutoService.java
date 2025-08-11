package com.orticulas.orticulas.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orticulas.orticulas.Repository.ProdutoRepository;
import com.orticulas.orticulas.modelClass.Produto;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + id));
    }
    public List<Produto> buscar(String nome) {
        return produtoRepository.findByNomePopularContainingIgnoreCaseAndNomeCientificoContainingIgnoreCase(nome, nome);
    }
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
    public Produto salvar(Produto produto) {
        if (produto.getNomePopular() == null || produto.getNomePopular().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome popular não pode ser vazio.");
        }
        if (produto.getNomeCientifico() == null || produto.getNomeCientifico().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome científico não pode ser vazio.");
        }
        if (produto.getDescricao() == null || produto.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        if (produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (produto.getDataColheita() == null) {
            throw new IllegalArgumentException("A data da colheita é obrigatória.");
        }
        if (produto.getEstado() == null || produto.getEstado().trim().isEmpty()) {
            throw new IllegalArgumentException("O estado não pode ser vazio.");
        }

        return produtoRepository.save(produto);
    }
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + id));

        if (produtoAtualizado.getNomePopular() != null && !produtoAtualizado.getNomePopular().isEmpty()) {
            produto.setNomePopular(produtoAtualizado.getNomePopular());
        }
        if (produtoAtualizado.getNomeCientifico() != null && !produtoAtualizado.getNomeCientifico().isEmpty()) {
            produto.setNomeCientifico(produtoAtualizado.getNomeCientifico());
        }
        if (produtoAtualizado.getDescricao() != null && !produtoAtualizado.getDescricao().isEmpty()) {
            produto.setDescricao(produtoAtualizado.getDescricao());
        }
        if (produtoAtualizado.getPreco() != null && produtoAtualizado.getPreco().compareTo(BigDecimal.ZERO) > 0) {
            produto.setPreco(produtoAtualizado.getPreco());
        }
        if (produtoAtualizado.getDataColheita() != null) {
            produto.setDataColheita(produtoAtualizado.getDataColheita());
        }
        if (produtoAtualizado.getEstado() != null && !produtoAtualizado.getEstado().isEmpty()) {
            produto.setEstado(produtoAtualizado.getEstado());
        }

        return produtoRepository.save(produto);
    }

    public void excluir(Long id) {

        if(!produtoRepository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }else {
            produtoRepository.deleteById(id);
        }
       
        
    }
    
}
