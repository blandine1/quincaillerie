package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.LigneCommandeClientDto;
import com.gestqua.gestqua.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public List<String> validate(LigneCommandeClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("la quqntite est necessaire");
        }

        if((clientDto != null ? clientDto.getQuantite() : null) < 0){
            errors.add("la quantite est obligatoire");
        }

        return  errors;
    }
}
