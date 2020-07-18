package com.invoicesystem.repository;

import com.invoicesystem.domain.ProviderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderCustomerRepository extends JpaRepository<ProviderCustomer,Integer> {
}
