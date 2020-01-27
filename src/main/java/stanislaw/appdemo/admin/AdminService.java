package stanislaw.appdemo.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import stanislaw.appdemo.user.User;

import java.util.List;

public interface AdminService {
    public List<User> findAll();

}
