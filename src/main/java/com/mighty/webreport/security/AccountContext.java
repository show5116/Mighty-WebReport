package com.mighty.webreport.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mighty.webreport.domain.entity.Member;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(of = {"id"})
public class AccountContext implements UserDetails {

    private String id;

    private String name;

    @JsonIgnore
    private String password;

    private Collection<? extends  GrantedAuthority> authorities;

    public AccountContext(Member member){
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(member.getRole()));

        this.id = member.getUserId();
        this.name = member.getUserName();
        this.password = member.getPassword();
        this.authorities = authorityList;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
