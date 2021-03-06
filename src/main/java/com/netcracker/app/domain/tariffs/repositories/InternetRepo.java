package com.netcracker.app.domain.tariffs.repositories;

import org.springframework.data.repository.CrudRepository;
import com.netcracker.app.domain.tariffs.entities.Internet;

import java.util.Optional;

public interface InternetRepo extends TariffRepository<Internet> {
    Iterable<Internet> findByName(String name);
    Optional<Internet> findById(Integer id);
    void deleteById(Integer id);

//    @Modifying
//    @Query("update Internet ii set ii.pack = ?1 where ii.id = ?2")
//    void setPackFor(String pack, Integer id);
//
//    @Modifying
//    @Query("update Internet ii set ii.price = ?1 where ii.id = ?2")
//    void setPriceFor(String price, Integer id);


}