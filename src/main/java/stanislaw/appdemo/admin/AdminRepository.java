package stanislaw.appdemo.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stanislaw.appdemo.user.User;

import java.util.List;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<User, Integer> {

    User getUserById(int id);    // Hibernate will generate query automatically;


    @Modifying  // Marking that something will be modified in database
    @Query(value = "UPDATE user_role ur SET ur.role_id = :roleId WHERE ur.user_id = :id", nativeQuery = true)    // NativeQuery = true means that query does not need any mapping for user_role
    void updateUserRole(@Param("roleId") int nrRole, @Param("id") int id);

    @Modifying  // Using parameters, nice
    @Query("UPDATE User u SET u.name = :#{#user.name}, u.lastName = :#{#user.lastName}, u.email = :#{#user.email}, u.active = :#{#user.active} WHERE u.id= :#{#user.id}")
    void updateUserBesidesPasswordAndRoles(@Param("user") User user );

    @Query(value = "SELECT * FROM User u WHERE u.name LIKE %:param% OR u.last_name LIKE %:param% OR u.email LIKE %:param%", nativeQuery = true)
    Page<User> findAllSearch(@Param("param") String param, Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM user_role WHERE user_id = :id", nativeQuery = true)
    void deleteUserFromUserRole(@Param("id") int id);

    @Modifying
    @Query(value = "DELETE FROM user WHERE user_id = :id", nativeQuery = true)
    void deleteUserFromUser(@Param("id") int id);
}

