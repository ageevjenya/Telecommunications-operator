package ru.shihaliev.telecom.repos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.shihaliev.telecom.domain.Advertising;

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
