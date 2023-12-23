package com.gestqua.gestqua.repository;

import com.gestqua.gestqua.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categorie, Integer> {
    Categorie findByName(String name);
}
