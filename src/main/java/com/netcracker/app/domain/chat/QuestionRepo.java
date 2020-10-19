package com.netcracker.app.domain.chat;


import com.netcracker.app.domain.notifications.Notification;
import com.netcracker.app.domain.users.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends PagingAndSortingRepository<Question, Long> {

    @Query(
            value = "SELECT * FROM Question  WHERE First_Question = true",
            nativeQuery = true)
    Question findByFirstQuestionNative();

}
