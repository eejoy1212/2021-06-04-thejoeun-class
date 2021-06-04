package com.example.class0604.Repository;

import com.example.class0604.DTO.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,String> {
}
