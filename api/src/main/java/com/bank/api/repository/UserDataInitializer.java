package com.bank.api.repository;

import java.util.Arrays;
import java.util.List;

import com.bank.api.model.User;


public class UserDataInitializer {
    
    public static List<User> getUsers() {
        return Arrays.asList(
            createUser1(),
            createUser2()
        );
    }

    private static User createUser1() {
        return new User(Long.valueOf(1), "Leanne Graham", "Bret", "Sincere@april.biz", "1-770-736-8031 x56442", "hildegard.org");
    }

    private static User createUser2() {
        return new User(Long.valueOf(2), "Ervin Howell", "Antonette", "Shanna@melissa.tv", "010-692-6593 x0912", "anastasia.net");
    }
    
}

