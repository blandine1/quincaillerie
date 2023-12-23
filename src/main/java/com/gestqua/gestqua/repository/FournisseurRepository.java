package com.gestqua.gestqua.repository;

import com.gestqua.gestqua.dto.FournisseurDto;
import com.gestqua.gestqua.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    Fournisseur findByPhone(String phone);

}
