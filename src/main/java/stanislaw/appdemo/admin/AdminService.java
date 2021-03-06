package stanislaw.appdemo.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stanislaw.appdemo.user.User;

import java.util.List;


public interface AdminService {
    Page<User> findAll(Pageable pageable);
    String findAllJson();
    User findUserById(int id);
    void updateUser(User user);
    Page<User> findAllSearch(String param, Pageable pageable);
    void insertInBatch(List<User> usersList);
    void deleteUserById(int id);

}
