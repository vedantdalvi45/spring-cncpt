package com.vedant.crud_demo.service.impl;

import com.vedant.crud_demo.repositories.MemberRepository;
import com.vedant.crud_demo.repositories.RoleRepository;
import com.vedant.crud_demo.entity.Member;
import com.vedant.crud_demo.entity.Role;
import com.vedant.crud_demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberServiceImpl implements MemberService {


    private MemberRepository memberRepository;

    private RoleRepository roleRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, RoleRepository roleRepository) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }

    @Override
    public List<Role> getRolesByUserId(String userId) {
        return roleRepository.findByMemberUserId(userId);
    }
}


