package com.farmy.project.farmy.project.model.repository;

import com.farmy.project.farmy.project.model.entity.Lamb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LambRepo extends JpaRepository<Lamb, Long> {

    Optional<Lamb> findByNum(long num);
}
