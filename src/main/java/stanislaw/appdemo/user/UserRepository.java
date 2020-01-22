package stanislaw.appdemo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")   // Telling Hibernate the name
public interface UserRepository extends JpaRepository<User, Integer> {  // Integer for User ID

    public User findByEmail(String email);
}
// Interface will tell Hibernate to create SQL query of: 'SELECT * FROM user WHERE user.email = ?"