package com.netcracker.app.domain.tariffs.repositories;

import com.netcracker.app.domain.tariffs.entities.TariffHome;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TariffHomeRepo extends TariffRepository<TariffHome> {
    Iterable<TariffHome> findByName(String name);
    //TariffHome findById(Long id);
    @Transactional
    void deleteById(Long id);

    @Query(value = "select * from TARIFF_HOME  where speed_Internet <= :maxSpeed", nativeQuery = true)
    List<TariffHome> findBeforeMaxSpeed(@Param("maxSpeed") String maxSpeed);

//    @Modifying
//    @Query("update Internet ii set ii.pack = ?1 where ii.id = ?2")
//    void setPackFor(String pack, Integer id);
//
//    @Modifying
//    @Query("update Internet ii set ii.price = ?1 where ii.id = ?2")
//    void setPriceFor(String price, Integer id);


}