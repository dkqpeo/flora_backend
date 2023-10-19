package com.flora.controller;

import com.flora.dto.user.LoginReqDTO;
import com.flora.dto.Response;
import com.flora.dto.user.SignUpReqDTO;
import com.flora.entity.UserEntity;
import com.flora.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"회원 관련"}, description = "회원 관련")
@RestController
@RequiredArgsConstructor  // 사용하는 객체에 맞는 생성자 생성
@Log4j2
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    // 생성자 주입 사용
    // --- 회원가입 및 로그인 관련

    // 회원가입 페이지에서 submit 했을 때 요청 처리
    @PostMapping("/signUp")
    @ApiOperation(value = "회원가입")
    public Response<?> signUp(@RequestBody SignUpReqDTO dto){
        return new Response<>(HttpStatus.CREATED, "가입 성공", userService.signUp(dto));
    }

    @GetMapping("/checkId/{id}")
    @ApiOperation(value = "아이디 중복 확인")
    public Response<?> checkId(@PathVariable String id){
        Boolean status;
        try{
            status = userService.checkId(id);
        } catch (Exception e){
            return new Response<>(HttpStatus.NOT_FOUND, "사용중인 아이디", null);
        }
        return new Response<>(HttpStatus.OK, "사용 가능한 아이디", status);
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인 로직")
    public Response<?> login (@RequestBody LoginReqDTO dto){
        UserEntity result;
        try{
            result = userService.login(dto);
        } catch (Exception e) {
            return new Response<>(HttpStatus.NOT_FOUND, "로그인 실패", null);
        }
        return new Response<>(HttpStatus.OK, "로그인 성공!", result);
    }
}
