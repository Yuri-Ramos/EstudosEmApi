package com.teste.primeiroexempro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiroexempro.model.Produto;
import com.teste.primeiroexempro.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    // A variable declaration.
    @Autowired
    private ProdutoService produtoService;

    @GetMapping   // quando alguém fizer alguma consulta para Api/produtos tras a listas com os produtos
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
}
    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id){
        return produtoService.obterPorId(id);

    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
    produtoService.deletar(id);
    return "Produto" +id + " Foi deletado com sucesso.";
    }
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto,@PathVariable Integer id ) {
        return produtoService.atualizar(id, produto);
    }
}
