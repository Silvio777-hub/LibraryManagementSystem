package com.library.domain;

import java.util.Objects;

/**
 * A book in the library catalogue.
 */
public record Book(String id, String title, String author, String isbn, BookStatus status) {

	public Book {
		Objects.requireNonNull(id, "id");
		Objects.requireNonNull(title, "title");
		Objects.requireNonNull(author, "author");
		Objects.requireNonNull(isbn, "isbn");
		Objects.requireNonNull(status, "status");
	}

	public boolean isAvailable() {
		return false;
	}
}