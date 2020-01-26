package stanislaw.appdemo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")   // Telling Hibernate the name
public interface UserRepository extends JpaRepository<User, Integer> {  // Integer for User ID

    public User findByEmail(String email);

    @Modifying  // Marking that something will be modified in database
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.email= :email")
    public void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);

    @Query("SELECT u.password FROM User u WHERE u.email= :email")   // Query for getting hashed password
    public String getPasswordByEmail(@Param("email") String email);


    @Modifying  // Marking that something will be modified in database
    @Query("UPDATE User u SET u.name = :newName, u.lastName = :newLastName, u.email = :newEmail  WHERE u.id= :id")
    public void updateUserProfile(@Param("newName") String  newName, @Param("newLastName") String newLastName, @Param("newEmail") String newEmail, @Param("id") int id);


}
// Interface will tell Hibernate to create SQL query of: 'SELECT * FROM user WHERE user.email = ?"