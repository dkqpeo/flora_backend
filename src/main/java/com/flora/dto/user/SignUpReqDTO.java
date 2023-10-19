package com.flora.dto.user;

import com.flora.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpReqDTO {
    private String userId;
    private String password;
    private String userName;
    private String tel;

    public static UserEntity toEntity(SignUpReqDTO dto){
        return UserEntity.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .userName(dto.getUserName())
                .tel(dto.getTel())
                .build();
    }
}
