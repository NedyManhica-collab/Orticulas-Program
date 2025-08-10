package com.orticulas.orticulas.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orticulas.orticulas.Repository.BulbosRepository;
import com.orticulas.orticulas.modelClass.Bulbos;

@Service
public class BulbosService {

    @Autowired
    private  BulbosRepository bulbosRepository;

    public Bulbos buscarPorId(Long id){

        return bulbosRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bulbo não encontrado com o ID: " + id));
    }

    public List<Bulbos> buscar(String nome){

        return bulbosRepository.findByNomePopularContainingIgnoreCaseAndNomeCientificoContainingIgnoreCase(nome, nome);
    }
    public List<Bulbos> listarBulbos(){

        return bulbosRepository.findAll();
    }

    public Bulbos salvar(Bulbos bulbos) {
    if (bulbos.getNomePopular() == null || bulbos.getNomePopular().trim().isEmpty()) {
        throw new IllegalArgumentException("O nome popular não pode ser vazio.");
    }
    if (bulbos.getNomeCientifico() == null || bulbos.getNomeCientifico().trim().isEmpty()) {
        throw new IllegalArgumentException("O nome científico não pode ser vazio.");
    }
    if (bulbos.getDescricao() == null || bulbos.getDescricao().trim().isEmpty()) {
        throw new IllegalArgumentException("A descrição não pode ser vazia.");
    }
    if (bulbos.getPreco() == null || bulbos.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
        throw new IllegalArgumentException("O preço deve ser maior que zero.");
    }
    if (bulbos.getDataColheita() == null) {
        throw new IllegalArgumentException("A data da colheita é obrigatória.");
    }
    if (bulbos.getEstado() == null || bulbos.getEstado().trim().isEmpty()) {
        throw new IllegalArgumentException("O estado não pode ser vazio.");
    }

    return bulbosRepository.save(bulbos);
}

    public Bulbos atualizar(Long id, Bulbos bulbosAtualizado){

      Bulbos bulbos = bulbosRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Bulbo não encontrado com o ID: " + id));

        if(bulbosAtualizado.getNomePopular() != null && !bulbosAtualizado.getNomePopular().isEmpty()){
            bulbos.setNomePopular(bulbosAtualizado.getNomePopular());
        }
        if(bulbosAtualizado.getNomeCientifico() != null && !bulbosAtualizado.getNomeCientifico().isEmpty()){
            bulbos.setNomeCientifico(bulbosAtualizado.getNomeCientifico());
        }
        if(bulbosAtualizado.getDescricao() != null && !bulbosAtualizado.getDescricao().isEmpty()){
            bulbos.setDescricao(bulbosAtualizado.getDescricao());
        }
        if(bulbosAtualizado.getImagem() != null){
            bulbos.setImagem(bulbosAtualizado.getImagem());
        }
        if(bulbosAtualizado.getPreco() != null){
            bulbos.setPreco(bulbosAtualizado.getPreco());
        }
        if(bulbosAtualizado.getDataColheita() != null){
            bulbos.setDataColheita(bulbosAtualizado.getDataColheita());
        }
        if(bulbosAtualizado.getEstado() != null && !bulbosAtualizado.getEstado().isEmpty()){
            bulbos.setEstado(bulbosAtualizado.getEstado());
        }

        return bulbosRepository.save(bulbos);
    }

    public void deletar(Long id)
    {
        if (!bulbosRepository.existsById(id)) {
            throw new IllegalArgumentException("Bulbo não encontrado com o ID: " + id);
        }else{
            bulbosRepository.deleteById(id);
        }
    }
    
}
