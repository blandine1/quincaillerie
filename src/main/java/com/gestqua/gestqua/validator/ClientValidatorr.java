package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidatorr {

    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();
        if (clientDto == null){
            errors.add("le nom du client est necessaire");
            errors.add("le nom du client est necessaire");

            return  errors;
        }
        if(!StringUtils.hasLength(clientDto.getName())){
            errors.add("le nom du client est necessaire");
        }
        if(!StringUtils.hasLength(clientDto.getPhone())){
            errors.add("le numero de telephone du client est necessaire");
        }
        return  errors;
    }
}
