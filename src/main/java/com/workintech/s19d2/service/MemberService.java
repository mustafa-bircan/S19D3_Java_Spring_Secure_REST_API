package com.workintech.s19d2.service;

import com.workintech.s19d2.dto.RegistrationMember;
import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.entity.Role;
import com.workintech.s19d2.repository.MemberRepository;
import com.workintech.s19d2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MemberService {


    private final RoleRepository roleRepository;
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberService(RoleRepository roleRepository, MemberRepository memberRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    /*public Member registerMember(RegistrationMember registrationMember) {
        Member member = new Member();
        member.setEmail(registrationMember.email());
        member.setPassword(passwordEncoder.encode(registrationMember.password()));

        Role userRole = roleRepository.findByAuthority("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Role adminRole = roleRepository.findByAuthority("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        roles.add(adminRole);
        member.setRoles(roles);

        return memberRepository.save(member);
    }*/
}