package com.flora.dto.order;

import com.flora.entity.OrderEntity;
import com.flora.entity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OrderReqDTO {
    private LocalDate date;
    private String item;
    private int price;
    private String itemImg;
    private String userName;
    private String postNum;
    private String address;
    private String detailAddress;
    private int status;
    private UserEntity userSeq;

    public static OrderEntity toEntity(OrderReqDTO dto){
        return OrderEntity.builder()
                .date(LocalDate.now())
                .item(dto.getItem())
                .price(dto.getPrice())
                .itemImg(dto.getItemImg())
                .postNum(dto.getPostNum())
                .address(dto.getAddress())
                .detailAddress(dto.getDetailAddress())
                .status(0)
                .userSeq(dto.getUserSeq())
                .build();
    }
}
