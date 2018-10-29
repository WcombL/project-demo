package com.lei.boot.repository;

import com.lei.boot.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByReader(String reader);
}
