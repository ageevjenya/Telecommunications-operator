package com.netcracker.app.info.services.faq;

import com.netcracker.app.info.entities.faq.Faq;

public interface FaqService<E extends Faq> {
    boolean existsById(int id);
    E getById(int id) throws Exception;
    Iterable<E> getAll();
    void updateQuestion(String question, int id) throws Exception;
    void updateAnswer(String answer, int id) throws Exception;
    void add(E e);
}
