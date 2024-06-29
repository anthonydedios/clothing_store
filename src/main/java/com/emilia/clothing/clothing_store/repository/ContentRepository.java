package com.emilia.clothing.clothing_store.repository;

import com.emilia.clothing.clothing_store.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);
}
