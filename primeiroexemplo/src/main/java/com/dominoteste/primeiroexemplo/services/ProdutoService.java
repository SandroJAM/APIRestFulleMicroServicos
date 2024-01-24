package com.dominoteste.primeiroexemplo.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dominoteste.primeiroexemplo.model.Produto;
import com.dominoteste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired // Deixa que eu tomo conta da instância vem do Spring.
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar umalista de produto.
     * 
     * @return Lista de produtos.
     */

    public List<Produto> obterTodos() {
        return produtoRepository.obterTodos();
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * 
     * @param id doproduto que será localizado
     * @return Retorna um produto caso tenha encontrado
     */

    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.obterPorId(id);
    }

    /**
     * Método para adicionar produto na lista.
     * 
     * @param produto que será adicionado
     * @return Retorna o produto que foi adcionado na lista.
     */

    public Produto adicionar(Produto produto) {
        // Pode ter várias regras de negócios aqui para validar o produto!
        return produtoRepository.adicionar(produto);
    }

    /**
     * Método para deletar produto na lista por Id.
     * 
     * @param Id
     */

    public void deletar(Integer Id) {
        // Aqui poderia ter uma lógica de validação.
        produtoRepository.deletar(Id);
    }

    /**
     * Método para atualizar o produto na lista.
     * 
     * @param produto que será atualizado.
     * @return Retorna o produto após atualizar a lista.
     */

    public Produto atualizar(Integer id, Produto produto) {
        // Poderia ter alguma regra de validação do Id.
        produto.setId(Id);
        return produtoRepository.atualizar(produto);
    }
}