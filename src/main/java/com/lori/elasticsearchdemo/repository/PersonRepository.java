package com.lori.elasticsearchdemo.repository;

import com.lori.elasticsearchdemo.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person,String> {
}
