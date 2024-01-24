package com.dominoteste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.dominoteste.primeiroexemplo.model.Produto;

@Repository /* O Spring toma conta da Injeção de Dependência e Inversão de Controle */
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos
     * 
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * 
     * @param id doproduto que será localizado
     * @return Retorna um produto caso tenha encontrado
     */

    public Optional<Produto> obterPorId(Integer id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Método para adicionar produto na lista.
     * 
     * @param produto que será adicionado
     * @return Retorna o produto que foi adcionado na lista.
     */

    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Método para deletar produto na lista por Id.
     * 
     * @param Id
     */

    public void deletar(Integer Id) {
        produtos.removeIf(produto -> produto.getId() == Id);
    }

    /**
     * Método para atualizar o produto na lista.
     * 
     * @param produto que será atualizado.
     * @return Retorna o produto após atualizar a lista.
     */

    public Produto atualizar(Produto produto) {

        // Encontrar o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if (produtoEncontrado.isEmpty()) { // Lançar exceção!
            throw new InputMismatchException("Produto não encontrado");
        }

        // Remover produto encontrado
        deletar(produto.getId());

        // Depois adiconar o produto atualizado.
        produtos.add(produto); // Não uso método adiconar senão ele vai incrementar e adiconar o Id
        return produto;
    }
}
