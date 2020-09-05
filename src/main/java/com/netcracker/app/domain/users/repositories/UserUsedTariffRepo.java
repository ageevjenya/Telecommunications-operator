package com.netcracker.app.domain.users.repositories;

import com.netcracker.app.domain.users.entities.UserUsedTariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUsedTariffRepo extends JpaRepository<UserUsedTariff, Long> {
    
}
