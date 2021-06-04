package com.example.class0604.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberDTO {
    String id;
    String name;
    String phone;

    public  Member toEntity(){
        return new Member(id,name,phone);
    }

}
