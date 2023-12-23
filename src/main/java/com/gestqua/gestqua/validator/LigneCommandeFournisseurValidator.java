package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.LigneCommandeFournisseurDto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public List<String> validate(LigneCommandeFournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();

        if(fournisseurDto == null){
            errors.add("la quqntite est necessaire");
        }

        if((fournisseurDto != null ? fournisseurDto.getQuantite() : null) < 0){
            errors.add("la quqntite est necessaire");
        }

        return  errors;
    }
}
