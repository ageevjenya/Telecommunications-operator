package com.netcracker.app.info.repositories.contacts;

import com.netcracker.app.info.entities.contacts.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ContactsRepository<E extends Contacts> extends JpaRepository<E, Integer> {
}
