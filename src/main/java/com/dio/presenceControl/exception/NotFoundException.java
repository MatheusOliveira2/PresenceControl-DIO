package com.dio.presenceControl.exception;

import com.dio.presenceControl.utils.MessageUtils;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super("Item not found");
    }
}
