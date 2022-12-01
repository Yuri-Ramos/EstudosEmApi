package com.teste.primeiroexempro.repository;

import org.springframework.data.JpaRepository
import org.springframework.stereotype.Repository;

import com.teste.primeiroexempro.model.Produto;
@Repository
public class ProdutoRepository {
    public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
        
    }
}
