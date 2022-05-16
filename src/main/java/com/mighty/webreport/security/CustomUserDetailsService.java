package com.mighty.webreport.security;

import com.mighty.webreport.domain.entity.admin.Member;
import com.mighty.webreport.domain.repository.admin.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] inputs = username.split(":");
        Member member = memberRepository.findByUserIdAndPlant(inputs[0],inputs[1])
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username : " + username));

        AccountContext accountContext = new AccountContext(member);
        return accountContext;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsernameAndPlant(AuthToken authToken) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserIdAndPlant(authToken.getId(), authToken.getPlant())
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username and plant : " + authToken.getId() + " , " + authToken.getPlant()));

        AccountContext accountContext = new AccountContext(member);
        return accountContext;
    }


}
