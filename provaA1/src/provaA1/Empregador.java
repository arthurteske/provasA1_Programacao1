package provaA1;

import java.util.Scanner;

public class Empregador {

		public static double funEmpregador (String estado, int func) {
			
			double novoBenefico = 0,  novoSalario;
			Scanner teclado = new Scanner(System.in);
					
			if (estado.equals("PA")) {				
					novoSalario = func * 200;
					novoBenefico = EstadoFunc.funcNovePorcento(novoSalario);
												
			} else {				
					novoBenefico = func * 200 ;					
			}			
			return novoBenefico;
		}
		
  }

