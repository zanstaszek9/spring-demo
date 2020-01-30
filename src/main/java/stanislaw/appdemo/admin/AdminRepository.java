package stanislaw.appdemo.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stanislaw.appdemo.user.User;
@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<User, Integer> {

    User getUserById(int id);    // Hibernate will generate query automatically;


    @Modifying  // Marking that something will be modified in database
    @Query(value = "UPDATE user_role ur SET ur.role_id = :roleId WHERE ur.user_id= :id", nativeQuery = true)    // NativeQuery = true means that query does not need any mapping for user_role
    void updateUserRole(@Param("roleId") int nrRole, @Param("id") int id);

    @Modifying  // Using parameters, nice
    @Query("UPDATE User u SET u.name = :#{#user.name}, u.lastName = :#{#user.lastName}, u.email = :#{#user.email}, u.active = :#{#user.active} WHERE u.id= :#{#user.id}")
    void updateUserBesidesPasswordAndRoles(@Param("user") User user );



}
