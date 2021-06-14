package application;

import java.util.Scanner;

import services.Conversion;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);  
         
        System.out.println("----------- Infix to Postfix -----------");
        System.out.print("-> Infix: ");
        String infix = sc.nextLine(); 

        Conversion conversion = new Conversion(infix); 
        
        System.out.print("=> Postfix: ");
        conversion.run(); 

        System.out.println(); 
        System.out.println("----------------------------------------");
        sc.close(); 
    }
}
