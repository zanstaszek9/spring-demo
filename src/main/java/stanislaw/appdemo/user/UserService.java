package stanislaw.appdemo.user;

import java.util.List;

// Interface for DAOs
public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
    void updateUserPassword(String newPassword, String email);
    String getPasswordByEmail(String email); // Need for getting old password
    void updateUserProfile(String newName, String newLastName, String newEmail, int id);
    //void updateUserActivation(int activation, String activationCode);
}
