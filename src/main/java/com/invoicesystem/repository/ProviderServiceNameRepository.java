package com.invoicesystem.repository;

import com.invoicesystem.domain.ProviderServiceName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderServiceNameRepository extends JpaRepository<ProviderServiceName,Integer> {
}
