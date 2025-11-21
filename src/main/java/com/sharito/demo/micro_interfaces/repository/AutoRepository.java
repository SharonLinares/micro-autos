package com.sharito.demo.micro_interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharito.demo.micro_interfaces.entity.AutoEntity;
import java.util.List;


@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Integer> {
	
	
	boolean  existsByMatricula(String matricula);
	
	AutoEntity findByMatricula(String matricula);
	
}
