package com.flora.service;

import com.flora.dto.order.OrderReqDTO;
import com.flora.entity.UserEntity;
import com.flora.repository.OrderRepository;
import com.flora.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void 신규_주문() {
        // 주문 요청시 전달해야 할 정보
        OrderReqDTO dto = new OrderReqDTO();
        dto.setItem("test1");  // 상품 명
        dto.setPrice(15000);  // 가격
        dto.setItemImg("https://www.naver.com"); // 이미지 주소
        dto.setUserName("test1");  // 로그인 사용자 이름
        dto.setPostNum("12345");  // 우편번호
        dto.setAddress("서울특별시 강남구 강남동"); // 주소
        dto.setDetailAddress("101호");    // 상세주소

        UserEntity userEntity = userRepository.findByUserName(dto.getUserName());

        if (userEntity != null){
            dto.setUserSeq(userEntity);
            orderRepository.save(dto.toEntity(dto));
            System.out.println("OrderService Test : 테스트 주문 성공");
        } else {
            throw new IllegalArgumentException("일치하는 아이디가 없습니다!");
        }
    }
}