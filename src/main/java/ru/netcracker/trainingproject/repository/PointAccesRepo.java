package ru.netcracker.trainingproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.netcracker.trainingproject.domain.PointAcces;

import java.util.Set;

public interface PointAccesRepo extends CrudRepository<PointAcces, Integer> {

//, TypePointAcces tp where p.id = tp.id and tp.TypePointAcces IN (?1)
//    @Query("select PointAcces from PointAcces p")
//    Iterable<PointAcces> selectPointAcces(Set type);
}
