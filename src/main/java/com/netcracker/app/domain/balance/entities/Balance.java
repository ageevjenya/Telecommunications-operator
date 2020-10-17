package com.netcracker.app.domain.balance.entities;
import com.netcracker.app.domain.users.entities.User;
import javax.persistence.Entity;

@Entity
public class Balance extends AbstractBalance {
    public Balance() {super();}

    public Balance(User user,double money,String number) {
        super(user,money,number);
    }
}
