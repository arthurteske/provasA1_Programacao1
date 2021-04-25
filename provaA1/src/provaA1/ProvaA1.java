package provaA1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ProvaA1 {
	

	public static void main(String[] args) {		
		// definindo as variaveis
		int usuarioLido = 0, beneficiárioLido = 0, diaNascimento, mesNascimento, anoNascimento, maiorTempo = 0, func, tempo, tempoDesempregado;
		double maiorValor =0, valorTotal = 0, beneficioEmpregado = 0,beneficioEmpregador = 0, beneficioDesempregado = 0;
		String estado, cargo = "", nome = "", aposentado, opcao = " ";	
		Boolean desejaContinuar = true, res = false;
		Scanner teclado = new Scanner(System.in);
		Scanner nomeCompleto = new Scanner(System.in);
		//iniciando sistema
		System.out.println("\n** Bem vindo ao sistema **");
		System.out.println("** Sistema para beneficio **");
		
		while (desejaContinuar == true) {	
			   
			//começando o sistema (entrada de dados)						
		System.out.println("Digite o nome completo do beneficiário: ");
		nome = nomeCompleto.nextLine();
		System.out.println("Digite o dia que o beneficiário nasceu");
		diaNascimento = teclado.nextInt();
		System.out.println("Digite o mes que o beneficiário nasceu: ");
		mesNascimento = teclado.nextInt();
		System.out.println("Digite o ano que o beneficiário nasceu: ");
		anoNascimento = teclado.nextInt();	
		
		//começa a validação de empregados
				
			//valida se o usuario tem mais de 18 anos
         	res = MaiorIdade.idadeMaior(anoNascimento);
        
         	//se for +18 retorna true e entra no menu de cargos
		if (res == true) {
			System.out.println("Qual é o estado em que voce reside? Exemplo PR");
			estado = teclado.next();
			
			System.out.println("Dos exemplos abaixo, digite qual é a situação do beneficiário no mercado de trabalho? ");
			System.out.println(" Empregador");
			System.out.println(" Empregado");
			System.out.println(" Desempregado");
			
			cargo = teclado.next();
			
			switch (cargo) {
			
			case "Empregador", "empregador":
				
				System.out.println("Quanto funcionarios há na sua empresa? ");
				func = teclado.nextInt();
				
				//chama metodo para calcular beneficio do empregador
				beneficioEmpregador = Empregador.funEmpregador(estado, func);
				
				if (func <= 10 && estado.equals("PA")) {
					System.out.println("O nome do beneficiário é: " + nome +
							"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e tem menos de dez funcionarios" +
							"\nReceberá os benefício de 9% a mais por morar no Pará e terá a duração de 10 meses por ter menos ou igual a 10 funcionarios" +
							"\nO valor total recebido é de: " + beneficioEmpregador);
				} else if (func <= 10 && !estado.equals("PA")) {
					System.out.println("O nome do beneficiário é: " + nome +
							"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e tem menos de dez funcionarios" +
							"\nA duração do benefício será de 10 meses por ter menos ou igual a  10 funcionarios " +
							"\nO valor total recebido é de: " + beneficioEmpregador);
				} else if(func > 10 && estado.equals("PA")) {
					System.out.println("Por quanto tempo esse usuario receberá o benefício? (obrigatoriamente precisa ser entre 2 a 12 meses)");
					tempo = teclado.nextInt();
					
					if (tempo >= 2 && tempo <= 12) {
					System.out.println("O nome do beneficiário é: " + nome +
							"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e tem mais de dez funcionarios" +
							"\nReceberá os beneficios de 9% a mais por morar no Pará " + "O tempo do benefício será de: " + tempo + 
							"\nO valor total recebido é de: " + beneficioEmpregador);
				  } else {
					System.out.println("O tempo solicitado não atende aos requisitos, porfavor inicialize do zero!");  
				  } 
					
				} else if(func > 10 && !estado.equals("PA")) {
					System.out.println("Por quanto tempo esse usuario receberá o benefício? (obrigatoriamente precisa ser entre 2 a 12 meses)");
					tempo = teclado.nextInt();
					
					if (tempo >= 2 && tempo <= 12) {
					System.out.println("O nome do beneficiário é: " + nome +
							"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e tem mais de dez funcionarios" +
							"\n" + "O tempo do benefício será de: " + tempo + " meses" +
							"\nO valor total de benefício recebido é de: " + beneficioEmpregador);
				  } else {
					System.out.println("O tempo solicitado não atende aos requisitos, porfavor inicialize do zero!");  
				  } 
				}
				
				usuarioLido++;
				beneficiárioLido++;
				valorTotal = valorTotal + beneficioEmpregador;
				break;
				
			case "Empregado", "empregado":
				
				System.out.println("O beneficiário é apostentado? S/N");
				aposentado = teclado.next();
				
				if (aposentado.equals("sim") || aposentado.equals("s") || aposentado.equals("S")) {
					//chama metodo para calcular aposetados 
					beneficioEmpregado = Aposentados.funcAposentado(estado);
					if (estado.equals("PA")) {
						System.out.println("O nome do beneficiário é: " + nome +
								"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e aposentado " +
								"\nReceberá o benefício de 9% a mais por morar no Pará e terá a duração de 6 meses" +
								"\nO valor total recebido é de: " + beneficioEmpregado);
					} else {
						System.out.println("O nome do beneficiário é: " + nome +
								"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e aposentado " +
								"\nReceberá o benefício com duração de 6 meses" +
								"\nO valor total recebido é de: " + beneficioEmpregado);
					}

					
				} else if (aposentado.equals("nao") || aposentado.equals("n") || aposentado.equals("N")) {
					//chama metodo para calcular beneficio do empregado
				     beneficioEmpregado = Empregados.funcEmpregados(estado);
					
					if (estado.equals("PA")) {
						System.out.println("O nome do beneficiário é: " + nome +
								"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade " +
								"\nReceberá o benefício de 9% a mais por morar no Pará e terá a duração de 3 meses" +
								"\nO valor total recebido é de: " + beneficioEmpregado);
					} else {
						System.out.println("O nome do beneficiário é: " + nome +
								"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade " +
								"\nReceberá o benefício com duração de 3 meses" +
								"\nO valor total recebido é de: " + beneficioEmpregado);
					}
					
				} else {
					System.out.println("Você digitou incorretamente, porfavor reinicialize o programa!");
					System.exit(0);
				}

				
				usuarioLido++;
				beneficiárioLido++;
				valorTotal = valorTotal + beneficioEmpregado;				
				break;
				
			case "Desempregado", "desempregado":
				/*chama metodo para calcular beneficio do Desempregado */
				
				System.out.println("Há quanto tempo o beneficiário está desempregado? ");
			    tempoDesempregado = teclado.nextInt();
			    
			    System.out.println("Por quanto tempo esse usuario receberá o benefício? (obrigatoriamente precisa ser entre 2 a 12 meses)");
				tempo = teclado.nextInt();
				
				beneficioDesempregado = Desempregados.funcDesempregado(estado, tempoDesempregado);

				if (tempo >= 2 && tempo <= 12) { 
			    if (tempoDesempregado <= 6 && estado.equals("PA")) {
					System.out.println("O nome do beneficiário é: " + nome +
							"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e terá uma redução de 10% do valor do benefício por estar desempregado a menos de 6 meses " +
							"\nReceberá o benefício de 9% a mais por morar no Pará "+
							"\nReceberá o benefício com duração de " + tempo +" meses" +
							"\nO valor total recebido é de: " + beneficioDesempregado);			    	
			     } else if (tempoDesempregado > 6 && estado.equals("PA")) {
			    	 System.out.println("O nome do beneficiário é: " + nome +
								"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
								"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e terá um aumento de 9% por residir no Pará " +
								"\nReceberá o benefício de 9% a mais por morar no Pará "+
								"\nReceberá o benefício com duração de " + tempo +" meses" +
								"\nO valor total recebido é de: " + beneficioDesempregado);
			    	 
			     } else if (tempoDesempregado <= 6 && !estado.equals("PA")) {
					System.out.println("O nome do beneficiário é: " + nome +
							"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e terá uma redução de 10% do valor do benefício por estar desempregado a menos de 6 meses " +
							"\nReceberá o benefício com duração de " + tempo +" meses" +
							"\nO valor total recebido é de: " + beneficioDesempregado);
			    	 
			     } else if (tempoDesempregado > 6 && !estado.equals("PA")) {
					System.out.println("O nome do beneficiário é: " + nome +
							"\nA data de nascimento do beneficiário é: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento + 
							"\nO cargo do beneficiário é: " + cargo + "\nO beneficiário é de maior idade e terá uma redução de 10% do valor do benefício por estar desempregado a menos de 6 meses " +
							"\nReceberá o benefício com duração de " + tempo +" meses" +
							"\nO valor total recebido é de: " + beneficioDesempregado);
			     }
				} else {
					System.out.println("Você digitou incorretamente, porfavor reinicialize o programa!");
					System.exit(0);
		     }

				usuarioLido++;
			    beneficiárioLido++;
			    valorTotal = valorTotal + beneficioDesempregado;	
				
				break;
			default:
				System.out.println("Você escreveu a opção incorretamente, porfavor reinicialize o programa! ");	
				System.exit(0);
			}
			
		}
		else {		
			System.out.println("Seu nome é: " + nome + "\nSua data de nascimento é: " + diaNascimento +"/"+mesNascimento+"/"+ anoNascimento +
					           "\nO beneficiário é menor de idade, infelizmente você não poderá receber ao benificio. ");
			usuarioLido++;
		}
		
		//retornar no menu
		System.out.println("\n " + "\nVocê deseja cadastrar um novo usuario? S/N");
		opcao = teclado.next();

		if (opcao.equals("s") || opcao.equals("S")) {
			desejaContinuar = true;
		} else if (opcao.equals("n") || opcao.equals("N")){
			desejaContinuar = false;
		}	else {
			System.out.println("Por favor digite uma opção valida!");
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
			System.out.println("Total de usuarios lidos são de: " + usuarioLido + 
								"\nTotal de beneficarios: " + beneficiárioLido + 
								"\nValor total pago de beneficio: " + valorTotal +
								"\nOs dois beneficiários que vão receber o maior valor são: " + maiorValor +
								"\nOs dois beneficiários que vão receber por mais tempo são: " + maiorTempo);
			System.exit(0);
		}
	teclado.close();
  }	
 }