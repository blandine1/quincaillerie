package com.gestqua.gestqua.Exceptions;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_ALREADY_EXIST(1001),
    ARTICLE_NOT_VALID(1002),
    CATEGORIE_NOT_FOUND(2000),
    CATEGORIE_ALREADY_EXIST(2001),
    CATEGORIE_NOT_VALID(2002),
    ClIENT_NOT_FOUND(3000),
    ClIENT_ALREADY_EXIST(3001),
    ClIENT_NOT_VALID(3002),
    FOURNISSEUR_NOT_FOUND(4000),
    FOURNISSEUR_ALREADY_EXIST(4001),
    FOURNISSEUR_NOT_VALID(4002),
    ADMINISTRATEUR_NOT_FOUND(5000),
    ADMINISTRATEUR_ALREADY_EXIST(5001),
    ADMINISTRATEUR_NOT_VALID(5002),
    COMMANDE_FOURNISSEUR_NOT_FOUND(6000),
    COMMANDE_FOURNISSEUR_ALREADY_EXIST(6001),
    COMMANDE_FOURNISSEUR_NOT_VALID(6002),

    COMMANDE_CLIENT_NOT_FOUND(7000),
    COMMANDE_CLIENT_ALREADY_EXIST(7001),
    COMMANDE_CLIENT_NOT_VALID(7002);

    private int code;
    ErrorCodes(int code){
         this.code=code;
    }

    public int getCode(){
        return  code;
    }
}