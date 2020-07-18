package com.invoicesystem.repository;

import com.invoicesystem.domain.ProviderInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderInvoiceRepository extends JpaRepository<ProviderInvoice,Integer> {
}
