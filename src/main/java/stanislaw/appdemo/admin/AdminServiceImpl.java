package stanislaw.appdemo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stanislaw.appdemo.user.User;

import java.util.List;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Qualifier("adminRepository")
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<User> findAll() {
        List<User> usersList = adminRepository.findAll();
        return usersList;
    }
}
