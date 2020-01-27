package stanislaw.appdemo.user;

import org.springframework.data.repository.query.Param;

import java.util.List;

// Interface for DAOs
public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
    public void updateUserPassword(String newPassword, String email);
    public String getPasswordByEmail(String email); // Need for getting old password
    public void updateUserProfile(String newName, String newLastName, String newEmail, int id);
    public List<User> findAll();
}
