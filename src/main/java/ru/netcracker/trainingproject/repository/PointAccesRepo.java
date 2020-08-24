package ru.netcracker.trainingproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.netcracker.trainingproject.domain.PointAcces;

import java.util.Collection;
import java.util.Set;

public interface PointAccesRepo extends CrudRepository<PointAcces, Integer> {

    @Query(
            value = "SELECT PointAcces FROM PointAcces p, TypePointAcces tp WHERE p.id = tp.id AND tp.TypePointAcces IN (?1)",
            nativeQuery = true)
    Collection<PointAcces> selectPointAcces(String type);
}
