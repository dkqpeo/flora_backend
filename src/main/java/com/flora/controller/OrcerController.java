package com.flora.controller;

import com.flora.dto.Response;
import com.flora.dto.order.OrderReqDTO;
import com.flora.entity.OrderEntity;
import com.flora.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"주문 관련"}, description = "주문 관련")
@RestController
@RequiredArgsConstructor  // 사용하는 객체에 맞는 생성자 생성
@Log4j2
@RequestMapping("/api/order")
public class OrcerController {
    private final OrderService orderService;

    @PostMapping("/new")
    @ApiOperation(value = "신규 주문")
    public Response<?> order(@RequestBody OrderReqDTO dto){
        OrderEntity result;
        try {
            result = orderService.order(dto);
        } catch (Exception e){
            return new Response<>(HttpStatus.NOT_FOUND, "사용자 조회 실패", null);
        }
        return new Response<>(HttpStatus.OK,"주문 완료", result);
    }
}
