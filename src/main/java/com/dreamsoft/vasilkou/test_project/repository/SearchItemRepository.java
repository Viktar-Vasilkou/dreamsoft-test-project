package com.dreamsoft.vasilkou.test_project.repository;

import com.dreamsoft.vasilkou.test_project.model.SearchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchItemRepository extends JpaRepository<SearchItem, Long> {
    List<SearchItem> findByOrderByTimeDesc();
}
