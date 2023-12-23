package com.gestqua.gestqua.repository;

import com.gestqua.gestqua.entity.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {
    Administrateur findByPhone(String phone);
}
