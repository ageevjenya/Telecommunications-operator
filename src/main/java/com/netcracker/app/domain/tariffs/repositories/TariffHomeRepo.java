package com.netcracker.app.domain.tariffs.repositories;

import com.netcracker.app.domain.tariffs.entities.TariffHome;

import java.util.Optional;

public interface TariffHomeRepo extends TariffRepository<TariffHome> {
    Iterable<TariffHome> findByName(String name);
    Optional<TariffHome> findById(Integer id);
    void deleteById(Integer id);

//    @Modifying
//    @Query("update Internet ii set ii.pack = ?1 where ii.id = ?2")
//    void setPackFor(String pack, Integer id);
//
//    @Modifying
//    @Query("update Internet ii set ii.price = ?1 where ii.id = ?2")
//    void setPriceFor(String price, Integer id);


}