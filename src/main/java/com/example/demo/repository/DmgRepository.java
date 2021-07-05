package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dmg;

@Repository
public interface DmgRepository extends JpaRepository<dmg, Long> {

	dmg findByLoginAndMdp(String login,String mdp);
}
