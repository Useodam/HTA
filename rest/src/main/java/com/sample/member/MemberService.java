package com.sample.member;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	
	private final MemberRepository memberRepository;
	
	public Member getMember(Long id) {
		Optional<Member> optional = memberRepository.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("회원정보가 존재하지 않습니다");
		}
		return optional.get();
	}

	public Member createMember(MemberRequest request) {
		if(memberRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("사용할 수 없는 이메일입니다");
		}
		return memberRepository.save(request.toEntity());
	}
	
	public void removeMember(Long id) {
		if(!memberRepository.existsById(id)) {
			throw new RuntimeException("회원정보가 존재하지 않습니다");
		}
		memberRepository.deleteById(id);
	}

	public Member modifyMember(Long id, MemberRequest request) {
		if(!memberRepository.existsById(id)) {
			throw new RuntimeException("회원정보가 존재하지 않습니다");
		}
		Member member = memberRepository.findById(id).get();
		BeanUtils.copyProperties(request, member);
		member.setUpdatedDate(LocalDateTime.now());
		
		return memberRepository.save(member);
		
	}

	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}
}
