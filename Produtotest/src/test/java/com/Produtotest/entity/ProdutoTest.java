package com.Produtotest.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto produto;

	@BeforeEach
	void setUp() {
		// Arrange
		produto = new Produto(null, "Savinho", "descricao", 20000);
	}

	@Test
	@DisplayName("Testando o getter e setter do campo Id")
	void testId() {
		// Act
		produto.setId(null);
		// Assert
		assertEquals(null, produto.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		// Act
		produto.setNome("Savinho");
		// Assert
		assertEquals("Savinho", produto.getNome());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo descricao")
	void testDescricao() {
		// Act
		produto.setDescricao("descricao");
		// Assert
		assertEquals("descricao", produto.getDescricao());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testPreco() {
		// Act
		produto.setPreco(20000);
		// Assert
		assertEquals(20000, produto.getPreco());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testeConstrutorAll() {
		// Act
		Produto novoProduto = new Produto(null, "Savinho", "descricao", 20000);
		// Assertion
		assertAll("novoProduto", () -> assertEquals(null, novoProduto.getId()),
				() -> assertEquals("Savinho", novoProduto.getNome()),
				() -> assertEquals("descricao", novoProduto.getDescricao()),
				() -> assertEquals(20000, novoProduto.getPreco()));
	}

}
