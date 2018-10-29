package com.lei.boot.repository;

import com.lei.boot.domain.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ReaderRepository extends MongoRepository<Reader, String> {

    UserDetails findByUsername(String username);
}
