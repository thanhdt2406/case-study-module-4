package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface IAppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update case4.app_user set status = !status where app_user_id = ?1", nativeQuery = true)
    void changeUserStatus(Long id);

    @Transactional
    @Query(value = "select * from app_user join app_role ar on ar.role_id = app_user.role_id and ar.name != ?1 and app_user.status=?2", nativeQuery = true)
    Page<AppUser> findAppUserAvailable(Pageable pageable, String roleName, boolean isAvailable);

    @Modifying
    @Transactional
    @Query(value = "update case4.app_user set role_id = (select app_role.role_id from app_role where app_role.name = ?1) where app_user_id = ?2",nativeQuery = true)
    void changeAppUserRole(String roleName,Long id);

}
