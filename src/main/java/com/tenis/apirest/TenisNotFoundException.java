package com.tenis.apirest;


class TenisNotFoundException extends RuntimeException {

    TenisNotFoundException(Long id) {
        super("Tenis não encontrado :( " + id);
    }
}
