import java.util.Scanner;

public class NivelMedio {

	public static void main(String[] args) {
		//EJERCICIO 1
		/*
		 
		 1) Crear un programa que pida al usuario escoger entre dos opciones:
			a. Ingresar peso en libras y altura en pulgadas
			b. Ingresar peso en kilogramos y altura en metros
				Una vez seleccionada la opción, pedir al usuario que ingrese peso y altura, y según esos
				datos calcular el índice de masa corporal. Si el índice de masa corporal es menor a 18.5
				se debe informar “bajo peso”, si esta entre 18.5 y 24.9 se debe informar “normal”, si
				esta entre 25 y 29.9 se debe informar “sobrepeso”, y si es mayor a 30 se debe informar
				“obeso”.
				Para calcular la masa corporal se debe hacer
			 	masaCorporal = (pesoEnLibras x 703)/(alturaEnPulgadas x alturaEnPulgadas)
				masaCorporal = pesoEnKilogramos/(alturaEnMetros x alturaEnMetros) 
			  
		  
		  */
		Scanner r = new Scanner(System.in);
		int res, opc;
		float peso, altura, masaCorporal;
		
		do{
		
			System.out.println("Seleccine el numero que corresponda \n ¿Como desea ingresar los datos? \n-0. Lib y pulg \n-1. kil y metr");
			opc = r.nextInt();
			
			if(opc == 0) 
			{
				System.out.println("Ingrese su peso en libras: ");
				peso = r.nextFloat();
				
				System.out.println("Ingrese su altura en pulgadas: ");
				altura = r.nextFloat();
				
				masaCorporal = (peso * 703) / (altura * altura);
				
				System.out.println("Su masa corporal es: " + masaCorporal);
			}
			else if(opc == 1)
			{
				System.out.println("Ingrese su peso en kilogramos: ");
				peso = r.nextFloat();
				
				System.out.println("Ingrese su altura en metros: ");
				altura = r.nextFloat();
				
				masaCorporal = peso / (altura * altura);
				
				System.out.println("Su masa corporal es: " + masaCorporal);
			}
			System.out.println("Seleccione el numero que corresponda \n ¿Desea seguir calculando? \n -0. Si \n -1. No\n Respuesta: ");
			res = r.nextInt();
		
		}while(res != 1);
		
		System.out.println("\n \t El programa a finalizado");
	}

	
	
	public static void EjercicioDos(String[] args) {
		
		//EJERCICIO 2
		/*
		 
		 2) Crear un programa para calcular los salarios semanales de unos empleados a los que se
			les paga 180 pesos la hora si éstas no superan las 35 horas. Cada hora por encima de
			las 35 se considerará extra y se paga a 240 pesos. La cantidad de horas no puede
			superar las 84.
			Para calcular e informar el sueldo de un empleado se debe pedir la cantidad de horas
			trabajadas por el mismo. Además el programa debe preguntar si se desea calcular otro
			salario, si es así el programa se vuelve a repetir.
		  
		  */
		Scanner r = new Scanner(System.in);
		int res, opc;
		
		do 
		{
			System.out.println("Ingrese ")
			
			
			System.out.println("Seleccione el numero que corresponda \n ¿Desea seguir calculando? \n -0. Si \n -1. No\n Respuesta: ");
			res = r.nextInt();
		}while(res != 1);
	}
}
