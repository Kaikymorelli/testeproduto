package com.Produtotest.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;

import com.Produtotest.entity.Produto;
import com.Produtotest.repository.ProdutoRepository;

@SpringBootTest
@Transactional
class ProdutoServicetest {

	@Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @BeforeEach
    void setUp() {
        produtoRepository.deleteAll(); // Limpa o banco de dados antes de cada teste
    }
    
    @DisplayName("Testando salvar Produto")
    @Test
    void testSalvarProduto() {
        Produto produto = new Produto(null, "Arroz", "Arroz Branco", 23.00);

        Produto resultado = produtoService.salvarProduto(produto);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Arroz", resultado.getNome());
        Assertions.assertTrue(resultado.getId() > 0);
    }
    
    @DisplayName("Testando listar todos os Produto")
    @Test
    void testListarTodos() {
        Produto produto1 = new Produto(null, "Arroz", "Arroz Branco", 23.00);
        Produto produto2 = new Produto(null, "Pó de café", "Melitta", 12.50);

        produtoService.salvarProduto(produto1);
        produtoService.salvarProduto(produto2);

        List<Produto> resultado = produtoService.listarTodos();

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(2, resultado.size());
    }
    
    @DisplayName("Testando buscar Produto por ID")
    @Test
    void testBuscarPorId() {
        Produto produto = new Produto(null, "Arroz", "Arroz Branco", 23.00);

        Produto salvo = produtoService.salvarProduto(produto);
        Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());

        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals("Arroz", resultado.get().getNome());
    }
    
    @DisplayName("Testando atualizar Produto")
    @Test
    void testAtualizarProduto() {
        Produto produto = new Produto(null, "Arroz", "Arroz Branco", 23.00);
        Produto salvo = produtoService.salvarProduto(produto);

        salvo.setNome("Chocolate");
        salvo.setDescricao("Cacau Show");

        Produto atualizado = produtoService.atualizarproduto(salvo);

        Assertions.assertNotNull(atualizado);
        Assertions.assertEquals("Chocolate", atualizado.getNome());
        Assertions.assertEquals("Cacau Show", atualizado.getDescricao());
    }
    
    @DisplayName("Testando deletar Produto")
    @Test
    void testDeletarProduto() {
        Produto produto = new Produto(null, "Arroz", "Arroz Branco", 23.00);

        Produto salvo = produtoService.salvarProduto(produto);
        produtoService.deletarProduto(salvo.getId());

        Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());

        Assertions.assertTrue(resultado.isEmpty());
    }
    
    
}
