package com.netcracker.app.domain.messages;

import com.netcracker.app.domain.requests.Request;
import com.netcracker.app.domain.users.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessagesRepo extends PagingAndSortingRepository<Message, Long> {


    @Query(value = "SELECT * FROM message WHERE request_id=:request", nativeQuery = true)
    Iterable<Message> findByRequest(@Param("request") Request request);
    Iterable<Message> findAll();
}
