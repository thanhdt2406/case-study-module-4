package com.codegym.casestudy4.service.appuser;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.repo.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements IAppUserService, UserDetailsService {
    @Autowired
    private IAppUserRepository iAppUserRepository;

    @Override
    public AppUser getUserByUsername(String username) {
        return iAppUserRepository.findByUsername(username);
    }

    @Override
    public AppUser getUserLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = this.getUserByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getAppRole());
        return new User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Iterable<AppUser> findAll() {
        return iAppUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return iAppUserRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        iAppUserRepository.save(appUser);
        return appUser;
    }

    @Override
    public void delete(Long id) {
        iAppUserRepository.deleteById(id);
    }
}
