package ru.netcracker.trainingproject.repository;

import org.springframework.data.repository.CrudRepository;
import ru.netcracker.trainingproject.domain.IntetyInternet;

public interface InternetRepository extends CrudRepository<IntetyInternet, Integer> {

}