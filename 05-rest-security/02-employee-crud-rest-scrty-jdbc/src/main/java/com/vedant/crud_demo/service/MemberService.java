package com.vedant.crud_demo.service;

import com.vedant.crud_demo.entity.Member;
import com.vedant.crud_demo.entity.Role;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member createMember(Member member);

    Optional<Member> findByUserId(String userId);

    List<Role> getRolesByUserId(String userId);
}

