package com.teste.primeiroexempro.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexempro.model.Produto;

@Repository
public class ProdutoRepository {
    
    // Creating a new ArrayList of Produtos.
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer  ultimoId = 0;



    /**
     * Retorna uma lista de produtos 
     * @return List de produtos
     */
    public List<Produto> obterTodos(){
            return produtos;

    }


//optional devolve null ou vazio sem erro

    /**
     * metodo que retorna o produto encontrado pelo seu ID 
     * 
     * @param id do produto que será localizado
     * @return retorna um produto caso tenha encontrado (optional)
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
    }


    /**
     * Metodo para adicionar produto 
     * @param produto
     * @return Retorna produto adicionado
     */
    public Produto adicionar( Produto produto){
        ultimoId++;  // pego o Id do produto
        produto.setId(ultimoId); //seto o id no produto 
        produtos.add(produto); // adiciono o produto
        return produto; 
    }
    /**
     * Metodo para deletar produto por ID
     * @param id
     */
    public void deletar(Integer id){
    produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para adicionar o produto na lista que será atualizado
     * @param produto que será atualizado
     * @return protudo atualizado
     */
        public Produto atualizar (Produto produto) {
          // encontrar o produto
                Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
                if( produtoEncontrado.isEmpty()){
                    throw new InputMismatchException("produto não Encontrado.");
                }
          // deletar o produto 
                deletar(produto.getId());

          // adicionar o produto atualizado na lsita 
                produtos.add(produto);
                return produto;
        }


}
