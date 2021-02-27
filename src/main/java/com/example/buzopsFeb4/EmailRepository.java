package com.example.buzopsFeb4;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface EmailRepository extends CrudRepository<Email,Integer> {
}
