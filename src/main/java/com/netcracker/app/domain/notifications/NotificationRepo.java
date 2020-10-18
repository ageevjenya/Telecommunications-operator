package com.netcracker.app.domain.notifications;

import com.netcracker.app.domain.users.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends PagingAndSortingRepository<Notification, Long> {
    @Query(
            value = "SELECT * FROM Notification n WHERE n.active = true AND user_id=:user",
            nativeQuery = true)
    Iterable<Notification> findAllActiveNotificationsNative(@Param("user") User user);
}
