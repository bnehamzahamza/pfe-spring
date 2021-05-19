package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ServiceConcerne;

@Repository
public interface ServiceConcerneRepository extends JpaRepository<ServiceConcerne, Long> {
	ServiceConcerne findByNom(String nom);
}
