package pl.jointrip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jointrip.dao.IAccountRepository;
import pl.jointrip.domain.Account;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    IAccountRepository accountRepository;

    public List<Account> findAll() {
        List<Account> retList = new ArrayList<>();
        for(Account acc : accountRepository.findAll()){
            retList.add(acc);
        }
        return retList;
    }
    //chuj kurwa jebac souretree ja kocham tylko konsole

    public void addAccount(Account acc){
        accountRepository.save(acc);
    }

    public Account getById(long id){
        Account acc = accountRepository.findById(id);
        return acc;
    }

    public Integer checkNickExists(String name){
        String userId;
        try{
            Account account = accountRepository.findByName(name);
            userId = String.valueOf(account.getId());
        }
        catch (Exception ex){
            return 0;
        }
        return 1;
    }

    public Integer checkEmailExists(String email){
        String userId;
        try{
            Account account = accountRepository.findByEmail(email);
            userId = String.valueOf(account.getId());
        }
        catch (Exception ex){
            return 0;
        }
        return 1;
    }
}
