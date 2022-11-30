package com.kma.demo.repository;

import com.kma.demo.entity.Film;
import com.kma.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {


    List<Film> findAll();
}
