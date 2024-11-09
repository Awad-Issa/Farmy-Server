package com.farmy.project.farmy.project.model.repository;

import com.farmy.project.farmy.project.model.entity.Sheep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheepRepo extends JpaRepository<Sheep, Long> {


}
