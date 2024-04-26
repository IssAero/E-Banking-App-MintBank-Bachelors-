package com.licentaebank.repository;

import com.licentaebank.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Modifying
    @Query(value = "INSERT INTO users (first_name, last_name, email, password, token, code) VALUES" +
            "(:first_name, :last_name, :email, :password, :token, :code)", nativeQuery = true )
    @Transactional
    void registerUser(@Param("first_name")String first_name,
                      @Param("last_name") String last_name,
                      @Param("email") String email,
                      @Param("password") String password,
                      @Param("token") String token,
                      @Param("code") int code);

    @Modifying
    @Query(value = "UPDATE users SET token=null, code=null, verified=1, verified_at=Now() WHERE token= :token AND code= :code", nativeQuery = true)
    @Transactional
    void verifyUser(@Param("token")String token, @Param("code")String code);

    @Query(value = "SELECT token FROM users WHERE token = :token" , nativeQuery = true)
    String checkToken(@Param("token")String token);
}
