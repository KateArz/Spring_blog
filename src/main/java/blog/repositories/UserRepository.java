package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query( "select u from User  u where u.username = :login AND u.passwordHash = :password" )
    List<User> findByCredentials(@Param("login") String login, @Param("password") String password);
}
