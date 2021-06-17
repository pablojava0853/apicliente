package com.brq.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brq.cliente.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findById(long id);
}
