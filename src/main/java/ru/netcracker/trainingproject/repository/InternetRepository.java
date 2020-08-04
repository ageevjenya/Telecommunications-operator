package ru.netcracker.trainingproject.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.netcracker.trainingproject.domain.IntetyInternet;

import java.util.List;
import java.util.Optional;

public interface InternetRepository extends CrudRepository<IntetyInternet, Integer> {
    Iterable<IntetyInternet> findByPack(String pack);
    Optional<IntetyInternet> findById(Integer id);
    void deleteById(Integer id);

    @Modifying
    @Query("update IntetyInternet ii set ii.pack = ?1 where ii.id = ?2")
    void setPackFor(String pack, Integer id);

    @Modifying
    @Query("update IntetyInternet ii set ii.price = ?1 where ii.id = ?2")
    void setPriceFor(String price, Integer id);


}