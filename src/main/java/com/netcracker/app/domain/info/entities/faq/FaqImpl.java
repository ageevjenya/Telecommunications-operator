package com.netcracker.app.domain.info.entities.faq;

import javax.persistence.Entity;

@Entity
public class FaqImpl extends AbstractFaq {
    public FaqImpl() { super(); }
    public FaqImpl(String question, String answer) {
        super(question, answer);
    }
}
