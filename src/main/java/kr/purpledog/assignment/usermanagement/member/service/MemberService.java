package kr.purpledog.assignment.usermanagement.member.service;

import kr.purpledog.assignment.usermanagement.global.exception.BadRequestException;
import kr.purpledog.assignment.usermanagement.global.exception.ConflictException;
import kr.purpledog.assignment.usermanagement.global.exception.NotFoundException;
import kr.purpledog.assignment.usermanagement.member.domain.Member;
import kr.purpledog.assignment.usermanagement.member.dto.MemberResponse;
import kr.purpledog.assignment.usermanagement.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse createMember(Member member) {
        if (memberRepository.existsById(member.getId())) throw new ConflictException(ConflictException.CauseCode.DUPLICATE, "아이디가 중복됩니다.");
        member = memberRepository.save(member);

        //TODO : 매핑할 필드가 많아지면 별도의 Mapper 를 이용해서 매핑하자 ex : ModelMapper
        return MemberResponse.builder()
                .id(member.getId())
                .password(member.getPassword())
                .build();
    }

    @Transactional
    public MemberResponse changePassword(String id, String password, String newPassword) {
        Member findMember = findMember(id);
        if (!findMember.getPassword().equals(password)) throw new BadRequestException("password", "잘못된 비밀번호입니다.");
        findMember.changePassword(newPassword);
        return MemberResponse.builder()
                .id(findMember.getId())
                .password(findMember.getPassword())
                .build();
    }

    @Transactional
    public boolean deleteMember(String id) {
        //TODO : 삭제 flag 에 해당하는 필드가 없어, 우선 raw data delete 처리
        memberRepository.delete(findMember(id));
        return true;
    }

    public Member findMember(String id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NotFoundException.CauseCode.NOT_FOUND_MEMBER, "존재하지 않는 회원입니다."));
    }

}
