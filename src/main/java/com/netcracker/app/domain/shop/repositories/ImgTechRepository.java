package com.netcracker.app.domain.shop.repositories;

import com.netcracker.app.domain.shop.entities.ImgTech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgTechRepository extends JpaRepository<ImgTech, Integer> {
    List<ImgTech> findAllByTechId(int id);
}
