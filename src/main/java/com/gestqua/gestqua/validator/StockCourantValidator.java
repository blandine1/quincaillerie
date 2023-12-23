package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.StockCourantDto;

import java.util.ArrayList;
import java.util.List;

public class StockCourantValidator {
    
    public List<String> validate(StockCourantDto stockCourantDto){
        List<String> errors = new ArrayList<>();
        
        if(stockCourantDto == null){
            errors.add("le stock courant est obligatoire");
        }

        if ((stockCourantDto != null ? stockCourantDto.getRestant() : null) < 0){
            errors.add("le stock courant est obligatoire");
        }
        
        
        return errors;
    }
}
