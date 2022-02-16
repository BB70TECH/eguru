package com.giobar.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.giobar.guru.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
