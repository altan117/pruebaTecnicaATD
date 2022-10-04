package pruebaTecnicaATD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PruebaTecnicaATD {

	private static Scanner sn;

	public static void main(String[] args) throws IOException {
		sn = new Scanner(System.in);
		boolean salir = false;
		// boolean continuar = false;
		int opcion; // Guardaremos la opcion del usuario

		while (!salir) {
			System.out.println("\nEscribe el número de una de las opciones:");
			System.out.println("1. Ejercicio 1 (Factorial)");
			System.out.println("2. Ejercicio 2 (Enunciado espejo)");
			System.out.println("3. Ejercicio 3 (Pirámide de latas)");
			System.out.println("4. Ejercicio 3 (Ocurrencia de dígitos)");
			System.out.println("5. Salir");
			try {

				opcion = sn.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Has seleccionado la opcion 1\n-------------------------------");
					System.out.println("Ingresa el número para calcular el factorial:");
					int valor = sn.nextInt();
					int num = factorial(valor);
					System.out.println("\nEl factorial de " + valor + " es: " + num);
					System.out.println("Deseas continuar con otro ejercicio? 1.Si 2.No");
					opcion = sn.nextInt();
					if (opcion == 1)
						break;
					else {
						salir = true;
						break;
					}
				case 2:
					System.out.println("Has seleccionado la opcion 2\n-------------------------------\n");
					System.out.println("Ingresa una frase, letra o palabra para obtener su espejo del abecedario:");
					String str = sn.next();
					String glass = glass(str);
					System.out.println("\nEl espejo de " + str + " es: " + glass);
					System.out.println("Deseas continuar con otro ejercicio? 1.Si 2.No");
					opcion = sn.nextInt();
					if (opcion == 1)
						break;
					else {
						salir = true;
						break;
					}
				case 3:
					System.out.println("Has seleccionado la opcion 3\n-------------------------------\n");
					System.out.println("Ingresa la colecta:");
					int colecta = sn.nextInt();
					System.out.println("Ingresa el precio:");
					int precio = sn.nextInt();
					int filas = piramid(colecta, precio);
					System.out.println("\nEl número de pisos de la pirámide es: " + filas);
					System.out.println("Deseas continuar con otro ejercicio? 1.Si 2.No");
					opcion = sn.nextInt();
					if (opcion == 1)
						break;
					else {
						salir = true;
						break;
					}
				case 4:
					System.out.println("Has seleccionado la opcion 4\n-------------------------------\n");
					System.out.println("Ingresa el tamaño del arreglo: ");
					String tam = sn.next();//new int[sn.nextInt()];
					// System.out.println("Ingresa el tamaño del arreglo de los
					// números a buscar:");
					/*for (int i = 0; i < tam.length; i++) {
						System.out.println("Ingresa el valor en la posición [" + i + "]:");
						tam[i] = sn.nextInt();
					}*/
					System.out.println("Cuantos numeros se van a buscar?: ");
					char tamArr =  (char) System.in.read();//new int[sn.nextInt()];
					/*for (int i = 0; i < tamArr.length; i++) {
						System.out.println("Ingresa el valor a buscar en la posición [" + i + "]:");
						tamArr[i] = sn.nextInt();
					}*/
					// System.out.println("Ingresa el número a buscar:");
					// int tamArr = sn.nextInt();
					HashMap<Character, Integer> resultado = ocurrencias(tam, tamArr);
					System.out.println(resultado.toString());
					System.out.println("Deseas continuar con otro ejercicio? 1.Si 2.No");
					opcion = sn.nextInt();
					if (opcion == 1)
						break;
					else {
						salir = true;
						break;
					}
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Opción inorrecta. Elije solo números entre 1 y 5");
				}
			} catch (InputMismatchException e) {
				System.out.println("ERROR: Debes insertar un número");
				sn.next();
			}
		}
	}

	private static int factorial(int i) {
		int f = 1;
		if (i == 0 || i == 1) {
			return 1;
		}
		for (int x = i; x > 0; x--) {
			f = f * x;

		}
		return f;

	}

	private static String glass(String s) {
		String[] abc = "abcdefghijklmnopqrstuvwxyz".split("");

		String[] str = s.split("");

		ArrayList<String> aabc = new ArrayList<String>();
		for (int i = 0; i < abc.length; i++)
			aabc.add(abc[i]);

		String nstr = "";

		for (String ss : str) {
			int idx = aabc.indexOf(ss);
			if (idx >= 0)
				nstr += abc[(abc.length - idx) - 1];
			ss = nstr;
		}

		return nstr.toString();
	}

	private static int piramid(int cost, int price) {
		int latas = cost / price;
		int fila = 0;
		int num = 1;
		int totalLatas = 0;
		while (totalLatas < latas) {
			totalLatas = (num * num) + totalLatas;
			num++;
			fila += 1;
		}
		if (totalLatas <= latas)
			return fila;
		else
			return fila - 1;
	}

	private static HashMap<Character, Integer> ocurrencias(String cadena, char caracter) {
		HashMap<Character, Integer> repetitions = new HashMap<Character, Integer>();
		int posicion, contador = 0;
		posicion = cadena.indexOf(caracter);
		while (posicion != -1) { 
			contador++; 
			posicion = cadena.indexOf(caracter, posicion + 1);
			repetitions.put(caracter, contador);
		}
		return repetitions;
	}

}
