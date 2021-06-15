package application;

import java.util.Scanner;

import services.Convertion;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
         
        System.out.println("----------- Infix to Postfix -----------");
        
        System.out.print("-> Infix: ");
        String infix = sc.nextLine(); 

        String postfix = Convertion.ConvertionInfixToPostfix(infix);
        
        System.out.println("=> Postfix: " + postfix);

        System.out.println("----------------------------------------");
        sc.close(); 
    }
}
