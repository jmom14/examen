package com.example.demo;

import java.util.Random;
import java.util.Scanner;

public class Examen{
    
     public static void main(String []args){
        Persona persona = new Persona();
        Scanner escaner = new Scanner (System.in);
        
        System.out.println("Escribe tu nombre:");
        String nombre = escaner.nextLine();
        persona.setNombre(nombre);

        System.out.println("Escribe tu edad:");
        int edad = Integer.parseInt(escaner.nextLine());
        persona.setEdad(edad);

        System.out.println("Escribe tu sexo(h/Hombre - m/Mujer)");
        char sexo = escaner.nextLine().charAt(0);
        persona.setSexo(sexo);

        System.out.println("Escribe tu peso en kg.");
        int peso = Integer.parseInt(escaner.nextLine());
        persona.setPeso(peso);

        System.out.println("Escribe tu altura en m.");
        double altura = Double.parseDouble(escaner.nextLine());
        persona.setAltura(altura);

        
        System.out.println("Es mayor de edad: " + persona.esMayorDeEdad());
        
        int imc = persona.calcularIMC();
        if (imc == 0){
            System.out.println("Peso normal");
        } else if(imc == 1) {
            System.out.println("Sobrepeso");
        } else if(imc == -1) {
            System.out.println("Falta de peso");
        }
        
        System.out.println(persona);
     }
}

class Persona{
    
    private String nombre;
    private int edad;
    private String nss;
    private char sexo;
    private int peso;
    private double altura;
    
    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.sexo = 'h';
        this.peso = 0;
        this.altura = 0;
        this.nss = generateNSS();
    }
    
    public Persona(String nombre, int edad, String nss, char sexo, int peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.nss = nss;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
    
    public void setNombre(String nombre) {this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setSexo(char sexo) { this.sexo = sexo; }
    public void setPeso(int peso) { this.peso = peso; } 
    public void setAltura(double altura) {this.altura = altura; }

    
    public int calcularIMC() {
        final int FALTA_DE_PESO = -1;
        final int PESO_NORMAL = 0;
        final int SOBREPESO = 1;
        int imc = 0;
        double pesoIdeal = peso / Math.pow(altura,2);
        
        if(this.sexo == 'h' || this.sexo == 'H'){
            if(pesoIdeal < 20){
                imc = FALTA_DE_PESO;
            }else if(pesoIdeal >=20 && pesoIdeal <=25){
                imc = PESO_NORMAL;
            }else{
                imc = SOBREPESO;
            }
        }else if(this.sexo == 'm' || this.sexo == 'M'){
            if(pesoIdeal < 19){
                imc = FALTA_DE_PESO;
            }else if(pesoIdeal >=19 && pesoIdeal <=24){
                imc = PESO_NORMAL;
            }else{
                imc = SOBREPESO;
            }
        }
        return imc;
    }
    
    public boolean esMayorDeEdad(){
        return (this.edad >= 18) ? true : false;
    }
    
    private boolean comprabarSexo(char sexo){
        return (this.sexo == sexo) ? true : false;
    }
    
    public String toString() {
        return 
        "nombre: " + this.nombre + 
        ", edad: " + this.edad + 
        ", sexo: " + this.sexo +
        ", peso: " + this.peso +
        ", altura: " + this.altura +
        ", nss: " + this.nss; 
    }
    
    private char obtenerRandomChar() {
        String options = "abcdefghijklmonpqrstuvwxyz1234567890";
        Random r = new Random();
        return options.charAt(r.nextInt(options.length()));
    }
    
    private String generateNSS() {
        StringBuilder nss = new StringBuilder();
        for(int i = 0; i < 8; i++){
            nss.append(obtenerRandomChar());
        }
        return nss.toString();
    }
}