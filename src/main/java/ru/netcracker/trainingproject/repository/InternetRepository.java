package ru.netcracker.trainingproject.repository;

import org.springframework.data.repository.CrudRepository;
import ru.netcracker.trainingproject.domain.IntetyInternet;

import java.util.List;

public interface InternetRepository extends CrudRepository<IntetyInternet, Integer> {
    List<IntetyInternet> findByPack(String Pack);

}