package br.ifce.tcc.clientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifce.tcc.clientapi.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {}
