package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.CommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors= new ArrayList();

        if(commandeClientDto  == null){
            errors.add("le client est necessaire");
        }

        if(commandeClientDto.getClientDto() == null){
            errors.add("le client est necessaire");
        }
        return errors;
    }
}
