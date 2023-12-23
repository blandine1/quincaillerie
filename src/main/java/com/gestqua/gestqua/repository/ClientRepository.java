package com.gestqua.gestqua.repository;

import com.gestqua.gestqua.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByPhone(String phone);
}
