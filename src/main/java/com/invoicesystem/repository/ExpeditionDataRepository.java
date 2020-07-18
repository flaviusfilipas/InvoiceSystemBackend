package com.invoicesystem.repository;

import com.invoicesystem.domain.ExpeditionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionDataRepository extends JpaRepository<ExpeditionData,Integer> {
}
