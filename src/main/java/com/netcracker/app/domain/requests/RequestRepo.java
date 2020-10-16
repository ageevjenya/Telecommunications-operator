package com.netcracker.app.domain.requests;

import com.netcracker.app.domain.users.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RequestRepo extends PagingAndSortingRepository<Request, Long> {

    @Query(value = "SELECT * FROM REQUEST WHERE user_id=:user order by active desc", nativeQuery = true)
    Iterable<Request> findByUserByOrderByActiveDesc(@Param("user") User user);

    Iterable<Request> findByOrderByActiveDesc();
}