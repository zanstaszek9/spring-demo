package stanislaw.appdemo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stanislaw.appdemo.user.Role;
import stanislaw.appdemo.user.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Qualifier("adminRepository")
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> usersList = adminRepository.findAll(pageable);
        return usersList;
    }

    @Override
    public Page<User> findAllSearch(String param, Pageable pageable) {
        Page<User> userList = adminRepository.findAllSearch(param, pageable);
        return userList;
    }

    @Override
    public User findUserById(int id) {
        User user = adminRepository.getUserById(id);
        return user;
    }


    @Override
    public void updateUser(User user) {
        adminRepository.updateUserRole(user.getNrRole(), user.getId());
        adminRepository.updateUserBesidesPasswordAndRoles(user);
    }
}
