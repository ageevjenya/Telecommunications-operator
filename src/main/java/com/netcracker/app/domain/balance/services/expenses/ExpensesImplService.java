package com.netcracker.app.domain.balance.services.expenses;

import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.balance.entities.expenses.Expenses;
import com.netcracker.app.domain.balance.repositories.expenses.ExpensesRepo;
import org.springframework.stereotype.Service;

@Service
public class ExpensesImplService extends AbstractExpensesService<Expenses> {
    private final ExpensesRepo repository;


    public ExpensesImplService(ExpensesRepo repository) {
        this.repository = repository;
    }


    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<Expenses> getAll() {
        return null;
    }

    @Override
    public void add(Expenses expenses) {

    }

    @Override
    public Expenses getById(int id){
        return null;
    }

    @Override
    public void updateMonthlyFee(String monthlyFee, int id) throws Exception {

    }

    @Override
    public void updatePackageActivationDate(String activationDate, int id) throws Exception {

    }

    @Override
    public void updateMessages(String messages, int id) throws Exception {

    }

    @Override
    public void updatePhoneCalls(String phoneCalls, int id) throws Exception {

    }

    @Override
    public void updateMobileInternet(String mobileInternet, int id) throws Exception {

    }

    @Override
    public void updateComplementaryServices(String complementaryServices, int id) throws Exception {

    }

    @Override
    public void updateHomeInternet(String homeInternet, int id) throws Exception {

    }
}