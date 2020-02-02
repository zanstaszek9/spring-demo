package stanislaw.appdemo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stanislaw.appdemo.user.Role;
import stanislaw.appdemo.user.RoleRepository;
import stanislaw.appdemo.user.User;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private JpaContext jpaContext;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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

    // TODO: Should be moved to separate microservice to not block the website
    @Override
    public void insertInBatch(List<User> usersList) {
        EntityManager entityManager = jpaContext.getEntityManagerByManagedType(User.class);
        setUsersRoleAndEncodePasswords(usersList);  // TODO: Interestingly, does not work now for more than 50. Need to put the content of that function into the for loop. I'll try to find out why.

        for(int i = 0; i < usersList.size(); i++){
            User user = usersList.get(i);
            entityManager.persist(user);
            if(i % 50 == 0 && i > 0){
                entityManager.flush();
                entityManager.clear();
                System.out.println("****\t Loaded " + i + " records from " + usersList.size() + "\t****");
            }
        }
    }

    private void setUsersRoleAndEncodePasswords(List<User> usersList){
        for (User user : usersList){
            Role role = roleRepository.findByRole("ROLE_USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(role)));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
    }
}
