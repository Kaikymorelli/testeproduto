package com.Produtotest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Produtotest.entity.Produto;

@DataJpaTest
class ProdutoRepositorytest {

	@Autowired
	private ProdutoRepository produtoRepository;

	@DisplayName("Testando o save")
	@Test
	void testSalvarRespository() {
		// Given / Arrange
		Produto produto1 = new Produto(null, "PC", "PC novo", 2800);
		// When / Act
		Produto saveProduto = produtoRepository.save(produto1);
		// Then / Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
	}

	@DisplayName("Testando Get para todos Produtos")
	@Test
	void testGetAllRespository() {
		// Given / Arrange
		Produto produto1 = new Produto(null, "PC", "PC novo", 2800);
		Produto produto2 = new Produto(null, "PC", "PC novo", 2000);
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		// When / Act
		List <Produto> produtoList = produtoRepository.findAll();
		// Then / Assert
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());
	}

	@DisplayName("Testando GET by ID")
	@Test
	void testGetById() {

		// Given / Arrange

		Produto produto1 = new Produto(null, "PC", "PC branco novo", 2000);

		produtoRepository.save(produto1);

		// When / Act
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();

		// Then / Assert
		assertNotNull(saveProduto);
		assertEquals(produto1.getId(), saveProduto.getId());
	}

	@DisplayName("Testando o update")
	@Test
	void testUpdateProduto() {

		// Given / Arrange

		Produto produto1 = new Produto(null, "PC", "PC branco novo", 2100);

		produtoRepository.save(produto1);

		// When / Act
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("PC");
		produto1.setDescricao("PC novo");
		produto1.setPreco(2.800);

		Produto updateProduto = produtoRepository.save(saveProduto);

		// Then / Assert
		assertNotNull(updateProduto);
		assertEquals("PC", updateProduto.getNome());
		assertEquals("PC novo", updateProduto.getDescricao());
		assertEquals(2.800, updateProduto.getPreco());
	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteProduto() {

		// Given / Arrange
		Produto produto1 = new Produto(null, "PC", "PC novo", 2800);

		produtoRepository.save(produto1);

		// When / Act
		produtoRepository.deleteById(produto1.getId());

		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());

		// Then / Assert
		assertTrue(produtoOptional.isEmpty());

	}
}
