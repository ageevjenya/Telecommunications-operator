package com.netcracker.app.domain.balance.services;

import com.netcracker.app.domain.balance.entities.AbstractBalance;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractBalanceService <E extends AbstractBalance> implements BalanceService<E> {

}
