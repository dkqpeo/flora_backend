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
    private LocalDate date;

    @Column
    private String item;

    @Column
    private int price;

    @Column
    private String itemImg;

    @Column
    private String postNum;

    @Column
    private String address;

    @Column
    private String detailAddress;

    @Column int status;  // 0 = 결제 대기, 1 = 결제 완료, 2 = 배송 준비중, 3 = 배송중, 4 = 배송완료.

    @ManyToOne
    @JoinColumn(name = "USER_SEQ")
    private UserEntity userSeq;
}
