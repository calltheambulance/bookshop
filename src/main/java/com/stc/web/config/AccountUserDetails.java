package com.stc.web.config;

import com.stc.web.models.State;
import com.stc.web.models.account.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//1 вопрос - что есть наш юзер?
@Getter
@RequiredArgsConstructor
public class AccountUserDetails implements UserDetails {

    private final Account account;

    public String getEmail() {
        return account.getEmail();
    }

    public String getName() {
        return account.getName();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + account.getRole().name()));
    }

    //Как получить пароль пользователя?
    @Override
    public String getPassword() {
        return account.getPassword();
    }


    //Как получить юзернейм(мэйл)?
    @Override
    public String getUsername() {
        return account.getEmail();
    }


    //Не просрочен ли аккаунт?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Не заблокирован ли аккаунт?
    @Override
    public boolean isAccountNonLocked() {
        return !account.getState().equals(State.BANNED);
    }

    //Не просрочены ли мэйл и пароль?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Активен ли аккаунт?
    @Override
    public boolean isEnabled() {
        return account.getState().equals(State.CONFIRMED);
    }
}
