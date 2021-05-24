package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Besoins;
import com.example.demo.model.Demande;

@Repository
public interface BesoinsRepository extends JpaRepository<Besoins, Long> {

	

}
