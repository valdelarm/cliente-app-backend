package br.com.martins.valdelar.clienteapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthResponse {
    private final String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
