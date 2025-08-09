import java.util.concurrent.*;

public class LiveUserSessionTracker {
    private static ConcurrentHashMap<String, Long> activeSessions = new ConcurrentHashMap<>();

    // Simulate a user logging in
    public static void userLogin(String username) {
        activeSessions.put(username, System.currentTimeMillis());
        System.out.println(username + " logged in. Active users: " + activeSessions.size());
    }

    // Simulate a user heartbeat (updating last activity time)
    public static void updateUserActivity(String username) {
        activeSessions.put(username, System.currentTimeMillis());
        System.out.println("Updated activity for " + username);
    }

    // Simulate a user logging out
    public static void userLogout(String username) {
        activeSessions.remove(username);
        System.out.println(username + " logged out. Active users: " + activeSessions.size());
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable simulateUser = () -> {
            String user = Thread.currentThread().getName();
            userLogin(user);
            try {
                Thread.sleep(500);
                updateUserActivity(user);
                Thread.sleep(500);
                userLogout(user);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread t1 = new Thread(simulateUser, "Alice");
        Thread t2 = new Thread(simulateUser, "Bob");
        Thread t3 = new Thread(simulateUser, "Charlie");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
