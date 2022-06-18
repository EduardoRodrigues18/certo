package com.tenis.apirest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenisRepository extends JpaRepository<Tenis,Long> {
}