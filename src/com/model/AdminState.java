package com.model;

public class AdminState {
    private Admin admin;

    public void saveState(Admin admin){
        this.admin=admin;
    }

    public Admin getAdminStatus() {
        return admin;
    }
}
