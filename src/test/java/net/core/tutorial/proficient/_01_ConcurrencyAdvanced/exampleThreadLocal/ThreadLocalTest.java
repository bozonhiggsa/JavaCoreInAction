package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleThreadLocal;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadLocalTest {

    @BeforeClass
    public static void repositoryCreating(){
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUser(1, "Ihor");
        userRepository.addUser(2, "Olga");
        userRepository.addUser(3, "Elena");
    }

    @Test
    public void testStoringUserDataInMap() {

        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        Thread thread1 = new Thread(firstUser);
        Thread thread2 = new Thread(secondUser);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(SharedMapWithUserContext.userContextPerUserId.size(), 2);
    }

    @Test
    public void testStoringUserDataInThreadLocal() {

        ThreadLocalWithUserContext firstUser = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser = new ThreadLocalWithUserContext(2);
        Thread thread1 = new Thread(firstUser);
        Thread thread2 = new Thread(secondUser);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}