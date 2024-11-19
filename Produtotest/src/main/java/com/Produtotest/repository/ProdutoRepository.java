package com.Produtotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Produtotest.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
