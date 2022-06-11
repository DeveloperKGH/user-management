package kr.purpledog.assignment.usermanagement.member.controller;

import kr.purpledog.assignment.usermanagement.global.BaseController;
import kr.purpledog.assignment.usermanagement.global.BaseResponse;
import kr.purpledog.assignment.usermanagement.member.dto.MemberRequest;
import kr.purpledog.assignment.usermanagement.member.dto.MemberResponse;
import kr.purpledog.assignment.usermanagement.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController extends BaseController {

    private final MemberService memberService;

    /**
     * 회원가입 API
     *
     * @param request 회원가입 요청 request
     * @param bindingResult request 검증 오류정보 저장
     * @return MemberResponse 가입회원 정보
     */
    @PostMapping("/members")
    public BaseResponse<MemberResponse> createMember(@RequestBody @Validated(MemberRequest.Create.class) MemberRequest request,
                                     BindingResult bindingResult) {
        log.debug("request : {}", request);
        checkBindings(bindingResult);
        MemberResponse response = memberService.createMember(request.toEntity());
        log.debug("response : {}", response);
        return BaseResponse.successResponse(response);
    }

    /**
     * 비밀번호 변경 API
     *
     * @param id 비밀번호 변경 할 회원의 ID
     * @param request 회원가입 요청 request
     * @param bindingResult request 검증 오류정보 저장
     * @return MemberResponse 비밀번호 변경 된 회원 정보
     */
    @PatchMapping("/members/{id}/password")
    public BaseResponse<MemberResponse> changePassword(@PathVariable String id,
                                                       @RequestBody @Validated(MemberRequest.ChangePassword.class) MemberRequest request,
                                                       BindingResult bindingResult) {
        log.debug("id : {}, password : {}, newPassword : {}", id, request.getPassword(), request.getNewPassword());
        checkBindings(bindingResult);
        MemberResponse response = memberService.changePassword(id, request.getPassword(), request.getNewPassword());
        log.debug("response : {}", response);
        return BaseResponse.successResponse(response);
    }

    /**
     * 회원삭제 API
     *
     * @param id 삭제 할 회원의 ID
     * @return Boolean 삭제 성공여부
     */
    @DeleteMapping("/members/{id}")
    public BaseResponse<Boolean> deleteMember(@PathVariable String id) {
        log.debug("id : {}", id);
        return BaseResponse.successResponse(memberService.deleteMember(id));
    }

}

