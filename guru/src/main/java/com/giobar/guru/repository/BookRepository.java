package com.giobar.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.giobar.guru.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
