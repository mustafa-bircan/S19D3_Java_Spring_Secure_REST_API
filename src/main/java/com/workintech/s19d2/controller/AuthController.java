package com.workintech.s19d2.controller;

import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    private final MemberService memberService;

    @Autowired
    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Member member) {
        memberService.save(member);

        Map<String, String> response = new HashMap<>();
        response.put("message", "kayıt başarılı bir şekilde gerçekleşti.");
        response.put("email", member.getEmail());
        return ResponseEntity.ok(response);
    }

}
