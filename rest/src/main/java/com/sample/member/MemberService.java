package com.sample.member;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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

	public List<Member> getAllMembers(Date startDate, Date endDate) {
		LocalDateTime start = this.getLocalDateTime(startDate);
		LocalDateTime end = this.getLocalDateTime(endDate);
		
		if(startDate != null && endDate != null) {
			return memberRepository.findByCreatedDateBetween(start, end);
		}
		
		if(startDate != null) {
			return memberRepository.findByCreatedDateAfter(start);
		}
		
		if(endDate != null) {
			return memberRepository.findByCreatedDateBefore(end);
		}
		
		return memberRepository.findAll();
	}
	
	/*
	 * java.util.Date를 LocalDateTime으로 변환해서 반환한다
	 * Date -> Instant -> ZoneDateTime -> LocalDateTime 순으로 변환해서 획득한다
	 * Instant : 1970년부터 현재 시간까지를 계산해서 나노조 단위의 값으로 표현하는 객체다
	 * ZondeDateTime : ZoneId + Instant 다
	 * 					ZoneId에 해당하는 특정 타임존 지역의 Instant 값을 표현한다
	 */
	private LocalDateTime getLocalDateTime(Date date) {
		if(date == null) {
			return null;
		}
		
		return date.toInstant()				// java.util.Date객체를 java.time.Instant객체로 변환
		.atZone(ZoneId.systemDefault())		// 타임존을 시스템의 타임존으로 설정, ZoneDateTime객체 획득
		.toLocalDateTime();					// 설정된 타임존에 맞는 LocalDateTime객체 획득
	}
}
