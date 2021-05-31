package me.joy.springbootsecurity;

import me.joy.springbootsecurity.account.Account;
import me.joy.springbootsecurity.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account joy = accountService.createAccount("joy", "1234");
        System.out.println(joy.getUsername() + " password: " + joy.getPassword());
    }
}
