package com.netcracker.app.shop.tariffs.repositories;

import org.springframework.data.repository.CrudRepository;
import com.netcracker.app.shop.tariffs.entities.Internet;

import java.util.Optional;

public interface InternetRepo extends CrudRepository<Internet, Integer> {
    Iterable<Internet> findByPack(String pack);
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