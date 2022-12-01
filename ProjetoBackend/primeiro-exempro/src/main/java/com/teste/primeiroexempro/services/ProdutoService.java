package com.teste.primeiroexempro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexempro.repository.ProdutoRepository_old;
import com.teste.primeiroexempro.shared.ProdutoDTO;

@Service
public class ProdutoService {

    @Autowired  // inverter a dependencia  sem precisar instanciar
    private ProdutoRepository_old produtoRepository;


      /**
     * Retorna uma lista de produtos 
     * @return List de produtos
     */
    public List<ProdutoDTO> obterTodos(){
        //colocar regra aqui
    return produtoRepository.obterTodos();
}

    /**
     * metodo que retorna o produto encontrado pelo seu ID 
     * 
     * @param id do produto que será localizado
     * @return retorna um produto caso tenha encontrado (optional)
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }


        /**
     * Metodo para adicionar produto 
     * @param produto
     * @return Retorna produto adicionado
     */
    public ProdutoDTO adicionar( ProdutoDTO produto){
        
        return produtoRepository.adicionar(produto);
    }
        /**
     * Metodo para deletar produto por ID
     * @param id
     */
    public void deletar(Integer id){
        // alguma logica de delete
         produtoRepository.deletar(id);
        }
      /**
     * Metodo para adicionar o produto na lista que será atualizado
     * @param produto que será atualizado
     * @param id Id do produto para ser atualizado
     * @return protudo atualizado
     */
    public ProdutoDTO atualizar (Integer id,ProdutoDTO produto) {
        // ter alguma validação 
        produto.setId(id);

       return produtoRepository.atualizar(produto);
      }
}
