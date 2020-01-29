package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static final UserRepository INSTANCE = new UserRepository();
    private Map<Integer, String> repository = new HashMap<>();

    private UserRepository(){
    }

    public static UserRepository getInstance(){
        return INSTANCE;
    }

    public void addUser(int userId, String userName){
        repository.put(userId, userName);
    }

    public String getUserNameForUserId(int userId){
        return repository.get(userId);
    }

}
