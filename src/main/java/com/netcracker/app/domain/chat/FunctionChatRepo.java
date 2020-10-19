package com.netcracker.app.domain.chat;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionChatRepo extends PagingAndSortingRepository<FunctionChat, Long> {
}
