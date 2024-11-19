package com.Produtotest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Produtotest.entity.Produto;
import com.Produtotest.repository.ProdutoRepository;

@Service
public class ProdutoService {
	

	 @Autowired
	    private ProdutoRepository produtoRepository;

	    public Produto salvarProduto(Produto produto) {
	        return produtoRepository.save(produto);
	    }

	    public List<Produto> listarTodos() {
	        return produtoRepository.findAll();
	    }

	    public Optional<Produto> buscarPorId(Long id) {
	        return produtoRepository.findById(id);
	    }

	    public Produto atualizarproduto(Produto produto) {
	        if (produtoRepository.existsById(produto.getId())) {
	            return produtoRepository.save(produto);
	        } else {
	            throw new RuntimeException("Produto não encontrado");
	        }
	    }

	    public void deletarProduto(Long id) {
	        produtoRepository.deleteById(id);
	    }

}
