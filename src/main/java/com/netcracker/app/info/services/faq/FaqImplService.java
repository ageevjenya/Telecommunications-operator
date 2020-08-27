package com.netcracker.app.info.services.faq;

import com.netcracker.app.info.entities.faq.FaqImpl;
import com.netcracker.app.info.repositories.faq.FaqImplRepository;
import com.netcracker.app.info.repositories.faq.FaqRepository;
import org.springframework.stereotype.Service;

@Service
public class FaqImplService extends AbstractFaqService<FaqImpl> {
    private final FaqImplRepository repository;

    public FaqImplService(FaqImplRepository repository, FaqRepository faqRepository) {
        super(faqRepository);
        this.repository = repository;
    }
}
