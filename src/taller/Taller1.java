package taller;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Taller1 {
	
	static String[] usuarios = new String[3];
	static String[] contraseñas = new String[3];
	static String[] IDS = new String[300];
	static String[] fechas = new String[300];
	static String[] dias = new String[300];
	static String[] meses= new String[300];
	static String[] años = new String[300];
	static int[] Horas = new int[300];
	static String[] Actividades = new String[300];
	static int Ocupado = 0;
	static String[] lineas = new String[300];
	static String nombreArchivoU = "txt\\Usuarios.txt";
	static String nombreArchivoR = "txt\\Usuarios.txt";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File archivoU = new File("txt\\Usuarios.txt");
		
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivoU));
			String lector;
			int i = 0;
			while((lector = entrada.readLine()) != null) {
				String[] partes = lector.split(";");
				String Usuario = partes[0];
				String Contraseña = partes[1];
				usuarios[i] = Usuario;
				contraseñas[i] = Contraseña;
				i++;
			}
		}catch (Exception e) {
			System.out.println("no se encontro el archivo usuarios");
		}
		
		File archivoR = new File("txt\\Registros.txt");
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivoR));
			String lectorR;
			int i = 0;
			while((lectorR = entrada.readLine()) != null) {
				String[] partesR = lectorR.split(";");
				String ID = partesR[0];
				String Fecha = partesR[1];
				String[] partesF = Fecha.split("/");
				int Hora = Integer.parseInt(partesR[2]);
				String Actividad = partesR[3];
				IDS[i] = ID;
				fechas[i] = Fecha;
				Horas[i] = Hora;
				Actividades[i] = Actividad;
				dias[i] = partesF[1];
				años[i] = partesF[2];
				lineas[i] = lectorR;
				i++;
				lectorR = entrada.readLine();
			}
		
		}catch (Exception e) {
			System.out.println("no se encontro el archivo Registros");
		}
		MenuPrincipal();
	}

	public static void MenuPrincipal() {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("1) Menu de usuarios");
			System.out.println("2) Menu de analisis");
			System.out.println("3) Salir");
			opcion = scanner.nextInt();
			
			switch(opcion) {
			case 1:
				//IngresoUsuario
			case 2:
				//MenuAnalisis
			case 3:
				System.out.println("Ha salido del menu");
				break;
			}
		}while(opcion != 3);
	}
	public static void IngresoUsuario() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Usuario: ");
		String UsuarioIngresado = scanner.nextLine();
		
		System.out.println("Contraseña: ");
		String ContraseñaIngresada = scanner.nextLine();
		
		for(int i= 0;i<usuarios.length;i++) {
			if(usuarios[i].equals(UsuarioIngresado) && contraseñas[i].equals(ContraseñaIngresada)) {
				System.out.println("Acceso correcto");
				//MenUsuario
			}
		}
	}
}
