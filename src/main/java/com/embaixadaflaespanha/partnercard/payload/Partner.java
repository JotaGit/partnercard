package com.embaixadaflaespanha.partnercard.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partner {
    Integer id;
    String name;
    String lastname;
    String nickname;
    String role;
    String order;
    String picture;
    String background;
}
