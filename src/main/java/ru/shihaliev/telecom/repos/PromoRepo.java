package ru.shihaliev.telecom.repos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.shihaliev.telecom.domain.Promo;

import java.util.List;

public interface PromoRepo extends CrudRepository<Promo,Long> {
    List<Promo> findByName(String name);

    List<Promo> findById(Integer id);

    void deleteById(Integer id);

    @Modifying
    @Query("update Promo ii set ii.description =?1 where ii.id = ?2")
    void setDescriptionFor(String description,Integer id);

    @Modifying
    @Query("update Promo ii set ii.name =?1 where ii.id = ?2")
    void setNameFor(String name, Integer id);

    @Modifying
    @Query("update Promo ii set ii.startDate =?1 where ii.id = ?2")
    void setStartDateFor(String startDate, Integer id);

    @Modifying
    @Query("update Promo ii set ii.endDate =?1 where ii.id = ?2")
    void setEndDateFor(String endDate, Integer id);


}
