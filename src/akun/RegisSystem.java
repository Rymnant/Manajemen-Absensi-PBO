package akun;
import java.util.ArrayList;
public class RegisSystem {
    boolean isLocked;
    private ArrayList<User> registeredUsers;
    public RegisSystem() {
        registeredUsers = new ArrayList<>();
    }
    public void register(User user) {
        lock();
        registeredUsers.add(user);
        unlock();
    }
    public boolean login(String email, String password) {
        lock();
        for (User user : registeredUsers) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    unlock();
                    return true;
                }
            }
        }
        unlock();
        return false;
    }
    private void lock() {
        while (isLocked) {
            // wait until system is unlocked
        }
        isLocked = true;
    }

    private void unlock() {
        isLocked = false;
    }
}
