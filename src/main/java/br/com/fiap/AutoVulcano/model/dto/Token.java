package br.com.fiap.AutoVulcano.model.dto;

public record Token (
    String token,
    String type,
    String prefix
) {}
