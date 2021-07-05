package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
	
Responsable findByDepartement(String Dep);
Responsable findByLoginAndMdp(String login,String mdp);
}
