package provaA1;

import java.util.Scanner;

public class Aposentados {

	public static double funcAposentado (String estado) {
		double novoBeneficio = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Entre 1.000,00 a 1.800,00, qual ser� o valor do benef�cio? ");
		double beneficio = teclado.nextInt();
		if (beneficio >= 1000 || beneficio < 1800) {
		   if (estado.equals("PA")) {						
			   novoBeneficio = EstadoFunc.funcNovePorcento(beneficio);	
		   } 
		   else {
			   novoBeneficio = beneficio;			
		   }
		   
		}
		else {
			  System.out.println("Seu beneficio est� fora dos limites padr�es, porfavor recome�e do zero!"); 
		   }
		return novoBeneficio;
	}
}
