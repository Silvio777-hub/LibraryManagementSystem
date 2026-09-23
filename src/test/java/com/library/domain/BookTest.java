package com.library.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Book}. Covers both branches of isAvailable() and every
 * null-validation branch.
 */
class BookTest {

	private static final String ID = "B1";
	private static final String TITLE = "Clean Code";
	private static final String AUTHOR = "Robert C. Martin";
	private static final String ISBN = "978-0132350884";

	@Test
	void whenStatusAvailable_thenIsAvailableTrue() {
		Book book = new Book(ID, TITLE, AUTHOR, ISBN, BookStatus.AVAILABLE);

		assertThat(book.isAvailable()).isTrue();
	}

	@Test
	void whenStatusBorrowed_thenIsAvailableFalse() {
		Book book = new Book(ID, TITLE, AUTHOR, ISBN, BookStatus.BORROWED);

		assertThat(book.isAvailable()).isFalse();
	}

	@Test
	void whenIdNull_thenConstructorThrows() {
		assertThatNullPointerException().isThrownBy(() -> new Book(null, TITLE, AUTHOR, ISBN, BookStatus.AVAILABLE))
				.withMessage("id");
	}

	@Test
	void whenTitleNull_thenConstructorThrows() {
		assertThatNullPointerException().isThrownBy(() -> new Book(ID, null, AUTHOR, ISBN, BookStatus.AVAILABLE))
				.withMessage("title");
	}

	@Test
	void whenAuthorNull_thenConstructorThrows() {
		assertThatNullPointerException().isThrownBy(() -> new Book(ID, TITLE, null, ISBN, BookStatus.AVAILABLE))
				.withMessage("author");
	}

	@Test
	void whenIsbnNull_thenConstructorThrows() {
		assertThatNullPointerException().isThrownBy(() -> new Book(ID, TITLE, AUTHOR, null, BookStatus.AVAILABLE))
				.withMessage("isbn");
	}

	@Test
	void whenStatusNull_thenConstructorThrows() {
		assertThatNullPointerException().isThrownBy(() -> new Book(ID, TITLE, AUTHOR, ISBN, null))
				.withMessage("status");
	}
}