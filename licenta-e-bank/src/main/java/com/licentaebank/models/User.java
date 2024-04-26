package com.licentaebank.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    private int user_id;
    @NotEmpty(message = "Campul 'Prenume' nu poate sa fie gol")
    @Size(min=3, message = "Campul 'Prenume' trebuie sa contina macar 3 caractere")
    private String first_name;
    @NotEmpty(message = "Campul 'Nume' nu poate sa fie gol")
    @Size(min=3, message = "Campul 'Nume' trebuie sa contina macar 3 caractere")
    private String last_name;
    @Email
    @NotEmpty(message = "Campul 'Email' nu poate sa fie gol")
    @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})", message = "Introdu o adresa valida de email")
    private String email;
    @NotEmpty(message = "Campul 'Parola' nu poate sa fie gol")
    @Size(min=8, message = "Campul 'Parola' trebuie sa contina macar 8 caractere")
    private String password;
    private String token;
    private int code;
    private int verified;
    private LocalDate verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public LocalDate getVerified_at() {
        return verified_at;
    }

    public void setVerified_at(LocalDate verified_at) {
        this.verified_at = verified_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
