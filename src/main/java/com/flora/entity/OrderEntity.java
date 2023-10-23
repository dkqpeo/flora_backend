package com.flora.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AI
    private Long seq;

    @Column
    private LocalDate date;  // 구매일자 자동삽입

    @Column
    private String flowerName;  // 상품 명

    @Column
    private int price;  // 가격

    @Column
    private String flowerImg;  // 상품 이미지

    @Column
    private String postNum;  // 우편번호

    @Column
    private String address;  // 기본주소

    @Column
    private String detailAddress;  // 상세주소

    @Column int status;  // 0 = 결제 대기, 1 = 결제 완료, 2 = 배송 준비중, 3 = 배송중, 4 = 배송완료.

    @ManyToOne
    @JoinColumn(name = "USER_SEQ")
    private UserEntity userSeq;  // 구매자 정보
}
