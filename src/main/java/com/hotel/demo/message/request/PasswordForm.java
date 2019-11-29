package com.hotel.demo.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordForm {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 50)
    private String username;

    @NotBlank
    @Size(min = 3)
    private String newPassword;

    @NotBlank
    @Size(min = 3)
    private String currentPassword;

    public PasswordForm(Long id, @NotBlank @Size(min = 2, max = 50) String username, @NotBlank @Size(min = 3) String newPassword, @NotBlank @Size(min = 3) String currentPassword) {
        this.id = id;
        this.username = username;
        this.newPassword = newPassword;
        this.currentPassword = currentPassword;
    }

    public PasswordForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;

    }
}
