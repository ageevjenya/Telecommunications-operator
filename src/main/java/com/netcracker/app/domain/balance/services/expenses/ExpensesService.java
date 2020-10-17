package com.netcracker.app.domain.balance.services.expenses;

import com.netcracker.app.domain.balance.entities.expenses.AbstractExpenses;
import com.netcracker.app.domain.balance.entities.expenses.Expenses;

public interface ExpensesService <E extends AbstractExpenses> {
    boolean existsById(Long id);
    Iterable<E> getAll();
    void add(E e);
    E getById(int id);
    void updateMonthlyFee(String monthlyFee, int id) throws Exception;
    void updatePackageActivationDate(String activationDate, int id) throws Exception;
    void updateMessages(String messages, int id) throws Exception;
    void updatePhoneCalls(String phoneCalls, int id) throws Exception;
    void updateMobileInternet(String mobileInternet, int id) throws Exception;
    void updateComplementaryServices(String complementaryServices, int id) throws Exception;
    void updateHomeInternet(String homeInternet, int id) throws Exception;
}
