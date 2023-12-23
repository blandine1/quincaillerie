package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.Administrateur;
import com.gestqua.gestqua.entity.Role;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
public class AdministrateurDto {
    private Integer id;
    private String firstname;
    private String secoundname;
    private String phone;
    private String email;
    private String password;
    private Role role;

    public static AdministrateurDto fromEntity(Administrateur administrateur){
        if(administrateur== null){
            return  null;
        }

        return AdministrateurDto.builder()
                .id(administrateur.getId())
                .firstname(administrateur.getFirstname())
                .secoundname(administrateur.getSecoundname())
                .phone(administrateur.getPhone())
                .email(administrateur.getEmail())
                .password(administrateur.getPassword())
                .role(administrateur.getRole())
                .build();
    }

    public static Administrateur toEntity(AdministrateurDto administrateurDto){
        if(administrateurDto==null){
            return  null;
        }
        Administrateur administrateur = new Administrateur();
        administrateur.setId(administrateurDto.getId());
        administrateur.setFirstname(administrateurDto.getFirstname());
        administrateur.setSecoundname(administrateurDto.getSecoundname());
        administrateur.setPhone(administrateurDto.getPhone());
        administrateur.setEmail(administrateurDto.getEmail());
        administrateur.setPassword(administrateurDto.getPassword());
        administrateur.setRole(administrateurDto.getRole());

        return administrateur;
    }
}
