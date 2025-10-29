package com.mycompany.techstore;

import formularios.LoginForm;
import modelos.SistemaTechStore;

public class Main {

    public static void main(String[] args) {
        SistemaTechStore sistemaTechStore = new SistemaTechStore();
        LoginForm loginForm = new LoginForm(sistemaTechStore);
        
        loginForm.setVisible(true);
        loginForm.setLocationRelativeTo(null);
    }
}
