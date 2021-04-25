package provaA1;

import java.util.Scanner;

public class Desempregados {
	public static double funcDesempregado (String estado, int tempoDesempregado) {
		double novoBeneficio = 0, beneficio = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Entre 1.500,00 a 2.300,00, qual será o valor do benefício? ");
		beneficio  = teclado.nextInt();
		
		if (beneficio >= 1500 || beneficio < 2300) {
			if (tempoDesempregado > 6) {				
				   if (estado.equals("PA")) {						
					   novoBeneficio = EstadoFunc.funcNovePorcento(beneficio);	
				   } 
				   else {
					   novoBeneficio = beneficio;			
				   }
				   
			} else {
				   if (estado.equals("PA")) {						
					   novoBeneficio = EstadoFunc.funcNovePorcento(beneficio);
					   novoBeneficio = DesempregadoSeis.menorQueSeis(novoBeneficio);
				   } 
				   else {
					   novoBeneficio = beneficio;
					   novoBeneficio = DesempregadoSeis.menorQueSeis(novoBeneficio);
				   }
			}
		}
		else {
			  System.out.println("Seu beneficio está fora dos limites padrões, porfavor reinicialize o sistema!"); 
			  System.exit(0);
		   }
		return novoBeneficio;
	}
}

