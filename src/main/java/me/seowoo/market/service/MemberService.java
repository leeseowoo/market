package me.seowoo.market.service;

import lombok.RequiredArgsConstructor;
import me.seowoo.market.dto.MemberResponseDto;
import me.seowoo.market.repository.MemberRepository;
import me.seowoo.market.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
    }

    // 현재 SecurityContext에 있는 회원 정보 가져오기
    @Transactional(readOnly = true)
    public MemberResponseDto getMyInfo() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 회원 정보가 없습니다."));
    }
}
