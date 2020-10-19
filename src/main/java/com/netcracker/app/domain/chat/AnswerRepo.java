package com.netcracker.app.domain.chat;

import com.netcracker.app.domain.users.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends PagingAndSortingRepository<Answer, Long> {

    @Query(
            value = "SELECT * FROM answer WHERE before_Question_id = :question",
            nativeQuery = true)
    Iterable<Answer> findByQuestionNative(@Param("question") Question question );
}
