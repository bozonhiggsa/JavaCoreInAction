package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleThreadLocal;

public class ThreadLocalWithUserContext implements Runnable {

    private static ThreadLocal<Context> userContext = new ThreadLocal<>();
    private Integer userId;
    private UserRepository userRepository = UserRepository.getInstance();

    public ThreadLocalWithUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContext.set(new Context(userName));
        System.out.println("thread context for given userId: "
                + userId + " is: " + userContext.get());
    }
}
