package com.giobar.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.giobar.guru.domain.Book;
import com.giobar.guru.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
