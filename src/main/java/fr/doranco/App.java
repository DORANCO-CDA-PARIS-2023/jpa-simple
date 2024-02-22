package fr.doranco;


import fr.doranco.jpasimple.service.JpaCLI;


public class App {

    public static void main(String[] args) {
        JpaCLI jpaCLI = new JpaCLI(System.in);
        System.exit(jpaCLI.start());
    }
}
