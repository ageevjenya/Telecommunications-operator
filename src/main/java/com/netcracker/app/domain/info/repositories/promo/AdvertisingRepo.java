package com.netcracker.app.domain.info.repositories.promo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.netcracker.app.domain.info.entities.promo.Advertising;

import java.util.List;

public interface AdvertisingRepo extends CrudRepository<Advertising,Long> {
    List<Advertising> findByName(String name);

    List<Advertising> findById(Integer id);

    void deleteById(Integer id);

    @Modifying
    @Query("update Advertising ii set ii.description =?1 where ii.id = ?2")
    void setDescriptionFor(String description,Integer id);

    @Modifying
    @Query("update Advertising ii set ii.name =?1 where ii.id = ?2")
    void setNameFor(String name, Integer id);
}
