package com.dominoteste.primeiroexemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominoteste.primeiroexemplo.model.Produto;
import com.dominoteste.primeiroexemplo.services.ProdutoService;

@RestController // Informa ao Spring que ele é o controlador, mais fica ouvindo em barra
                // (localhost:8080).
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired // Agora o controle está comigo.
    private ProdutoService produtoService;

    @GetMapping // Cheme esse método se alguén fizer consulta /api/produtos.
    public List<Produto> obterTodos() {
        return produtoService.obterTodos(); // Passa a responsabilidades para o Serviço.
    }
}