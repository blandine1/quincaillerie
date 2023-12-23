package com.gestqua.gestqua.Exceptions;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    //cette clase est generique

    @Getter
    private ErrorCodes errorCodes;

    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message,Throwable cause){
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable throwable, ErrorCodes errorCodes){
      super(message, throwable);
      this.errorCodes=errorCodes;
    }

    public EntityNotFoundException(String message,ErrorCodes errorCodes){
        super(message);
        this.errorCodes=errorCodes;
    }


}
