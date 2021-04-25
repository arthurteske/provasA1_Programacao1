package provaA1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ProvaA1 {
	

	public static void main(String[] args) {		
		// definindo as variaveis
		int usuarioLido = 0, benefici�rioLido = 0, diaNascimento, mesNascimento, anoNascimento, maiorTempo = 0, func, tempo, tempoDesempregado;
		double maiorValor =0, valorTotal = 0, beneficioEmpregado = 0,beneficioEmpregador = 0, beneficioDesempregado = 0;
		String estado, cargo = "", nome = "", aposentado, opcao = " ";	
		Boolean desejaContinuar = true, res = false;
		Scanner teclado = new Scanner(System.in);
		Scanner nomeCompleto = new Scanner(System.in);
		//iniciando sistema
		System.out.println("\n** Bem vindo ao sistema **");
		System.out.println("** Sistema para beneficio **");
		
		while (desejaContinuar == true) {	
			   
			//come�ando o sistema (entrada de dados)						
		System.out.println("Digite o nome completo do benefici�rio: ");
		nome = nomeCompleto.nextLine();
		System.out.println("Digite o dia que o benefici�rio nasceu");
		diaNascimento = teclado.nextInt();
		System.out.println("Digite o mes que o benefici�rio nasceu: ");
		mesNascimento = teclado.nextInt();
		System.out.println("Digite o ano que o benefici�rio nasceu: ");
		anoNascimento = teclado.nextInt();	
		
		//come�a a valida��o de empregados
				
			//valida se o usuario tem mais de 18 anos
         	res = MaiorIdade.idadeMaior(anoNascimento);
        
         	//se for +18 retorna true e entra no menu de cargos
		if (res == true) {
			System.out.println("Qual � o estado em que voce reside? Exemplo PR");
			estado = teclado.next();
			
			System.out.println("Dos exemplos abaixo, digite qual � a situa��o do benefici�rio no mercado de trabalho? ");
			System.out.println(" Empregador");
			System.out.println(" Empregado");
			System.out.println(" Desempregado");
			
			cargo = teclado.next();
			
			switch (cargo) {
			
			case "Empregador", "empregador":
				
				System.out.println("Quanto funcionarios h� na sua empresa? ");
				func = teclado.nextInt();
				
				//chama metodo para calcular beneficio do empregador
				beneficioEmpregador = Empregador.funEmpregador(estado, func);
				
				if (func <= 10 && estado.equals("PA")) {
					System.out.println("O nome do benefici�rio �: " + nome +
							"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e tem menos de dez funcionarios" +
							"\nReceber� os benef�cio de 9% a mais por morar no Par� e ter� a dura��o de 10 meses por ter menos ou igual a 10 funcionarios" +
							"\nO valor total recebido � de: " + beneficioEmpregador);
				} else if (func <= 10 && !estado.equals("PA")) {
					System.out.println("O nome do benefici�rio �: " + nome +
							"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e tem menos de dez funcionarios" +
							"\nA dura��o do benef�cio ser� de 10 meses por ter menos ou igual a  10 funcionarios " +
							"\nO valor total recebido � de: " + beneficioEmpregador);
				} else if(func > 10 && estado.equals("PA")) {
					System.out.println("Por quanto tempo esse usuario receber� o benef�cio? (obrigatoriamente precisa ser entre 2 a 12 meses)");
					tempo = teclado.nextInt();
					
					if (tempo >= 2 && tempo <= 12) {
					System.out.println("O nome do benefici�rio �: " + nome +
							"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e tem mais de dez funcionarios" +
							"\nReceber� os beneficios de 9% a mais por morar no Par� " + "O tempo do benef�cio ser� de: " + tempo + 
							"\nO valor total recebido � de: " + beneficioEmpregador);
				  } else {
					System.out.println("O tempo solicitado n�o atende aos requisitos, porfavor inicialize do zero!");  
				  } 
					
				} else if(func > 10 && !estado.equals("PA")) {
					System.out.println("Por quanto tempo esse usuario receber� o benef�cio? (obrigatoriamente precisa ser entre 2 a 12 meses)");
					tempo = teclado.nextInt();
					
					if (tempo >= 2 && tempo <= 12) {
					System.out.println("O nome do benefici�rio �: " + nome +
							"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e tem mais de dez funcionarios" +
							"\n" + "O tempo do benef�cio ser� de: " + tempo + " meses" +
							"\nO valor total de benef�cio recebido � de: " + beneficioEmpregador);
				  } else {
					System.out.println("O tempo solicitado n�o atende aos requisitos, porfavor inicialize do zero!");  
				  } 
				}
				
				usuarioLido++;
				benefici�rioLido++;
				valorTotal = valorTotal + beneficioEmpregador;
				break;
				
			case "Empregado", "empregado":
				
				System.out.println("O benefici�rio � apostentado? S/N");
				aposentado = teclado.next();
				
				if (aposentado.equals("sim") || aposentado.equals("s") || aposentado.equals("S")) {
					//chama metodo para calcular aposetados 
					beneficioEmpregado = Aposentados.funcAposentado(estado);
					if (estado.equals("PA")) {
						System.out.println("O nome do benefici�rio �: " + nome +
								"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e aposentado " +
								"\nReceber� o benef�cio de 9% a mais por morar no Par� e ter� a dura��o de 6 meses" +
								"\nO valor total recebido � de: " + beneficioEmpregado);
					} else {
						System.out.println("O nome do benefici�rio �: " + nome +
								"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e aposentado " +
								"\nReceber� o benef�cio com dura��o de 6 meses" +
								"\nO valor total recebido � de: " + beneficioEmpregado);
					}

					
				} else if (aposentado.equals("nao") || aposentado.equals("n") || aposentado.equals("N")) {
					//chama metodo para calcular beneficio do empregado
				     beneficioEmpregado = Empregados.funcEmpregados(estado);
					
					if (estado.equals("PA")) {
						System.out.println("O nome do benefici�rio �: " + nome +
								"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade " +
								"\nReceber� o benef�cio de 9% a mais por morar no Par� e ter� a dura��o de 3 meses" +
								"\nO valor total recebido � de: " + beneficioEmpregado);
					} else {
						System.out.println("O nome do benefici�rio �: " + nome +
								"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade " +
								"\nReceber� o benef�cio com dura��o de 3 meses" +
								"\nO valor total recebido � de: " + beneficioEmpregado);
					}
					
				} else {
					System.out.println("Voc� digitou incorretamente, porfavor reinicialize o programa!");
					System.exit(0);
				}

				
				usuarioLido++;
				benefici�rioLido++;
				valorTotal = valorTotal + beneficioEmpregado;				
				break;
				
			case "Desempregado", "desempregado":
				/*chama metodo para calcular beneficio do Desempregado */
				
				System.out.println("H� quanto tempo o benefici�rio est� desempregado? ");
			    tempoDesempregado = teclado.nextInt();
			    
			    System.out.println("Por quanto tempo esse usuario receber� o benef�cio? (obrigatoriamente precisa ser entre 2 a 12 meses)");
				tempo = teclado.nextInt();
				
				beneficioDesempregado = Desempregados.funcDesempregado(estado, tempoDesempregado);

				if (tempo >= 2 && tempo <= 12) { 
			    if (tempoDesempregado <= 6 && estado.equals("PA")) {
					System.out.println("O nome do benefici�rio �: " + nome +
							"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e ter� uma redu��o de 10% do valor do benef�cio por estar desempregado a menos de 6 meses " +
							"\nReceber� o benef�cio de 9% a mais por morar no Par� "+
							"\nReceber� o benef�cio com dura��o de " + tempo +" meses" +
							"\nO valor total recebido � de: " + beneficioDesempregado);			    	
			     } else if (tempoDesempregado > 6 && estado.equals("PA")) {
			    	 System.out.println("O nome do benefici�rio �: " + nome +
								"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e ter� um aumento de 9% por residir no Par� " +
								"\nReceber� o benef�cio de 9% a mais por morar no Par� "+
								"\nReceber� o benef�cio com dura��o de " + tempo +" meses" +
								"\nO valor total recebido � de: " + beneficioDesempregado);
			    	 
			     } else if (tempoDesempregado <= 6 && !estado.equals("PA")) {
					System.out.println("O nome do benefici�rio �: " + nome +
							"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e ter� uma redu��o de 10% do valor do benef�cio por estar desempregado a menos de 6 meses " +
							"\nReceber� o benef�cio com dura��o de " + tempo +" meses" +
							"\nO valor total recebido � de: " + beneficioDesempregado);
			    	 
			     } else if (tempoDesempregado > 6 && !estado.equals("PA")) {
					System.out.println("O nome do benefici�rio �: " + nome +
							"\nA data de nascimento do benefici�rio �: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do benefici�rio �: " + cargo + "\nO benefici�rio � de maior idade e ter� uma redu��o de 10% do valor do benef�cio por estar desempregado a menos de 6 meses " +
							"\nReceber� o benef�cio com dura��o de " + tempo +" meses" +
							"\nO valor total recebido � de: " + beneficioDesempregado);
			     }
				} else {
					System.out.println("Voc� digitou incorretamente, porfavor reinicialize o programa!");
					System.exit(0);
		     }

				usuarioLido++;
			    benefici�rioLido++;
			    valorTotal = valorTotal + beneficioDesempregado;	
				
				break;
			default:
				System.out.println("Voc� escreveu a op��o incorretamente, porfavor reinicialize o programa! ");	
				System.exit(0);
			}
			
		}
		else {		
			System.out.println("Seu nome �: " + nome + "\nSua data de nascimento �: " + diaNascimento +"/"+mesNascimento+"/"+ anoNascimento +
					           "\nO benefici�rio � menor de idade, infelizmente voc� n�o poder� receber ao benificio. ");
			usuarioLido++;
		}
		
		//retornar no menu
		System.out.println("\n " + "\nVoc� deseja cadastrar um novo usuario? S/N");
		opcao = teclado.next();

		if (opcao.equals("s") || opcao.equals("S")) {
			desejaContinuar = true;
		} else if (opcao.equals("n") || opcao.equals("N")){
			desejaContinuar = false;
		}	else {
			System.out.println("Por favor digite uma op��o valida!");
			desejaContinuar = false;
		}
		
		/* tentativa de montar um array para mostrar o maior valor
		List<Double> valores = new ArrayList<> ();
		valores.add(beneficioEmpregador);
		valores.add(beneficioDesempregado);
		valores.add(beneficioEmpregado);
		Arrays.toString(valores.toArray());
		
		ArrayList<String> nomes = new ArrayList<> ();
		nomes.add(nome);
		Arrays.toString(nomes.toArray());
		
		for (int i = 0; i < valores.size(); i++) {
			valores.set(i, beneficioEmpregador);
			valores.set(i, beneficioEmpregado);
			valores.set(i, beneficioDesempregado);
			nomes.set(i, nome);
		}
		*/		
	}
		
		if (desejaContinuar == false) {
			System.out.println("Total de usuarios lidos s�o de: " + usuarioLido + 
								"\nTotal de beneficarios: " + benefici�rioLido + 
								"\nValor total pago de beneficio: " + valorTotal +
								"\nOs dois benefici�rios que v�o receber o maior valor s�o: " + maiorValor +
								"\nOs dois benefici�rios que v�o receber por mais tempo s�o: " + maiorTempo);
			System.exit(0);
		}
	teclado.close();
  }	
 }