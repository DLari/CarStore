package ru.reksoft.interns.carstore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
public class UsersDto {

    private Integer id;

    @NotBlank
    @Size(min = 5,max = 20)
    private String fio;

    @NotEmpty
    @Past
    private Date dateOfBirth;

    @Pattern(regexp = "\\w{7}")
    private String login;

    @Pattern(regexp = "(?-i)(?=^.{8,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\\d){1,})|(?=(.*\\W){1,}))^.*$")
    private String password;

    @NotBlank
    private String rule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
