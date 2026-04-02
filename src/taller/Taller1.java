package taller;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	static int TotalUsuarios = 0;
	static int TotalRegistros = 0;
	static String[] lineasU = new String[300];
	static String[] lineasR = new String[300];
	static String nombreArchivoU = "txt\\Usuarios.txt";
	static String nombreArchivoR = "txt\\Usuarios.txt";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File archivoU = new File(nombreArchivoU);
		
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivoU));
			String lector;

			while((lector = entrada.readLine()) != null) {
				String[] partes = lector.split(";");
				String Usuario = partes[0];
				String Contraseña = partes[1];
				usuarios[TotalUsuarios] = Usuario;
				contraseñas[TotalUsuarios] = Contraseña;
				lineasU[TotalUsuarios] = lector;
				TotalUsuarios++;
				
			}
		}catch(Exception e){
			System.out.println("no se encontro el archivo usuarios");
		}
		
		
		File archivoR = new File(nombreArchivoR);
		
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivoR));
			String lectorR;
			
			
			while((lectorR = entrada.readLine()) != null) {
				String[] partesR = lectorR.split(";");
				String ID = partesR[0];
				String Fecha = partesR[1];
				String[] partesF = Fecha.split("/");
				int Hora = Integer.parseInt(partesR[2]);
				String Actividad = partesR[3];
				IDS[TotalRegistros] = ID;
				
				fechas[TotalRegistros] = Fecha;
				Horas[TotalRegistros] = Hora;
				Actividades[TotalRegistros] = Actividad;
				dias[TotalRegistros] = partesF[0];
				meses[TotalRegistros] = partesF[1];
				años[TotalRegistros] = partesF[2];
				lineasR[TotalRegistros] = lectorR;
				
				TotalRegistros++;
				}
		}catch (Exception e) {
			System.out.println("no se encontro el archivo registros");
		}
		
		MenuPrincipal();
		
	}
	
	public static void MenuPrincipal() {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
		
			System.out.println("1) Menu de Usuarios");
			System.out.println("2) Menu de analisis");
			System.out.println("3) Salir");
			String entrada = scanner.nextLine();
			System.out.println();
		while(true) {
			
			try {
				opcion = Integer.parseInt(entrada);
				if(opcion >= 1 && opcion <=3) {
					break;
				}else {
					System.out.println("Ingrese una opcion valida");
				}
			}catch (Exception e) {
				System.out.println("ingrese solo un numero.");
			}
		}
		
			switch(opcion) {
			case 1:
				IngresoUsuario();
				break;
			case 2:
				//MenuAnalisis();
				break;
			case 3:
				System.out.println("ha salido del menu");
				break;
			
			}
		}while(opcion != 3);
	
	
	}
	
	public static void IngresoUsuario() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Usuario: ");
		String UsuarioIngresado = scanner.nextLine();
		
		System.out.print("Contraseña: ");
		String ContraseñaIngresada = scanner.nextLine();
		
		for(int i = 0;i<usuarios.length;i++) {
			if(usuarios[i].equals(UsuarioIngresado) && contraseñas[i].equals(ContraseñaIngresada)) {
				System.out.println("Acceso Correcto");
				MenUsuario(UsuarioIngresado);
			}
		}
	}
	
	public static void MenUsuario(String Usuario)  {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		System.out.printf("Bienvenido %s%n",Usuario);
		
		do {
			
			System.out.println("Que deseas realizar?");
			System.out.println("1) Registrar actividad");
			System.out.println("2) Modificar actividad");
			System.out.println("3) Eliminar actividad");
			System.out.println("4) Cambiar contraseña");
			System.out.println("5) Salir.");
			
			while(true) {
				System.out.print("Seleccione: ");
				String entrada = scanner.nextLine();
				System.out.println();
				
				try {
					opcion = Integer.parseInt(entrada);
					if(opcion>= 1 && opcion<=5) {
						break;
					}else {
						System.out.println("Seleccione una opcion valida");
					}
				}catch (Exception e) {
					System.out.println("ingrese solo un numero");
				}
			}
			switch(opcion) {
			case 1:
				RegistrarActividad(Usuario);
				break;
			case 2:
				SeleccionarAct(Usuario);
				break;
			case 3:
				//EliminarAct(Usuario);
				break;
			case 4:
				//CambiarContraseña(Usuario);
				break;
			case 5:
				MenuPrincipal();
				break;
			}
		}while(opcion != 5);
		
		
		
	}
	
	public static void RegistrarActividad(String Usuario) {
		 File archivo = new File(nombreArchivoR);
		 Scanner scanner = new Scanner(System.in);
		 if(TotalRegistros == 300) {
			 System.out.println("No se pueden agregar mas actividades");
			 return;
		 }
		 
		 int dia,mes,año,horas;
		 String Actividad;
		 
		 while(true) {
			 System.out.println("ingrese el dia (1-31): ");
			 String entrada = scanner.nextLine();
			 try {
				 dia = Integer.parseInt(entrada);
				 if(dia>=1 && dia<= 31) {
					 break;
				 }else {
					 System.out.println("ingrese un dia valido (1-31)");
				 }
			 }catch(Exception e) {
				 System.out.println("Ingrese solo numeros");
			 }
		 }
		 while(true) {
			 System.out.println("ingrese el mes (1-12): ");
			 String entrada = scanner.nextLine();
			 try {
				 mes = Integer.parseInt(entrada);
				 if(mes>= 1 && mes<= 12) {
					 break;
				 }else {
					 System.out.println("Ingrese un mes valido (1-12)");
				 }
			 }catch (Exception e) {
				 System.out.println("Ingrese solo numeros");
			 }
		 }
		 while(true) {
			 System.out.println("ingrese el año (1900-2026): ");
			 String entrada = scanner.nextLine(); 
			 try {
				 año = Integer.parseInt(entrada);
				 if(año>= 1900 && año<= 2026) {
					 break;
				 }else {
					 System.out.println("Ingrese un año valido (1900-2026");
				 }
			 }catch (Exception e) {
				 System.out.println("Ingrese solo numeros");
			 }
		 }
		 while(true) {
			 System.out.println("ingrese las horas");
			 String entrada = scanner.nextLine();
			 try {
				 horas = Integer.parseInt(entrada);
				 if(horas>= 0 && horas<= 23) {
					 break;
				 }else {
					 System.out.println("Ingrese horas validas (1-23)");
				 }
			 }catch (Exception e) {
				 System.out.println("ingrese solo numeros");
			 }
		 }
		 while(true) {
			 System.out.println("ingrese la actividad");
			 Actividad= scanner.nextLine();
			 
			 if(Actividad.equals(" ")) {
				 System.out.println("La actividad no puede estar vacia");
			 }else {
				 break;
			 }
			 
		 }
		 
		 String fecha = dia+"/"+mes+"/"+año+"/";
		 String ActividadIngresada = Usuario+";"+fecha+";"+horas+";"+Actividad;

		 fechas[TotalRegistros] = fecha;
		 Horas[TotalRegistros] = horas;
		 Actividades[TotalRegistros] = Actividad;
		 dias[TotalRegistros]= String.valueOf(dia);
		 meses[TotalRegistros] = String.valueOf(mes);
		 años[TotalRegistros] = String.valueOf(año);	
		 lineasR[TotalRegistros] = ActividadIngresada;
		 TotalRegistros++;
		 
		 
		 try (BufferedWriter salida = new BufferedWriter(new FileWriter(nombreArchivoR,true))){
			salida.write(ActividadIngresada);
			salida.newLine();
		 }catch (IOException e) {
			 System.out.println("no se encontro el archivo");
		 }
		 System.out.println("se ha registrado la actividad");
		 
		 
		 
	}
	
	public static void SeleccionarAct(String Usuario) {
		Scanner scanner = new Scanner(System.in);
		File ArchivoR = new File(nombreArchivoR);
		System.out.println("Cual deseas modificar: ");
		System.out.println();
		System.out.println("0) Regresar");
		int opcion = 1;
		String[] lineasSelec = new String[300];
		for(int i = 0;i<lineasR.length;i++) {
			if(IDS[i].equals(Usuario)) {
				System.out.printf("%d) %s%n",opcion++,lineasR[i]);
				lineasSelec[i] = lineasR[i];
			}	
		}
		while (true) {
			
			try {
				
				opcion = scanner.nextInt();
				System.out.println(lineasSelec.length);
				if(opcion>=0 && opcion<=lineasSelec.length) {
					break;
				}else {
					System.out.println("ingrese una opcion valida");
				}
			}catch(Exception e) {
				System.out.println("Ingrese solo un numero");
			}
		}
		
		String Seleccionada = lineasSelec[opcion-1];
		switch(opcion) {
		case 0:
			MenUsuario(Usuario);
			break;
		default:
			ModificarAct(Seleccionada,Usuario);
			break;
		}
		
	}
	
	public static void ModificarAct(String seleccionada,String Usuario) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Que deseas modificar");
		int opcion;
		do {
			
			System.out.println("0) Regresar");
			System.out.println("1) Fecha");
			System.out.println("2) Duracion");
			System.out.println("3) Tipo de actividad");
			while(true) {
				System.out.print("Seleccione");
				
				try {
					opcion = scanner.nextInt();
					if(opcion>=0 && opcion<=3) {
						break;
					}else {
						System.out.println("Ingrese una opcion valida");
					}
				}catch(Exception e) {
					System.out.println("Ingrese solo numeros");
				}
			}
			String[] partes = seleccionada.split(";");
			switch(opcion) {
			case 0 :
				SeleccionarAct(Usuario);
				break;
			case 1:
				int dia,mes,año;
				while(true) {
					System.out.println("ingrese el nuevo dia (1-31): ");
					String entrada = scanner.nextLine();
					try {
						dia = Integer.parseInt(entrada);
						if(dia>=1 && dia<= 31) {
							break;
						}else {
							System.out.println("Ingrese una opcion valida (1-31)");
						}
					}catch(Exception e) {
						System.out.println("ingrese un numero");
					}
				}
				while(true) {
					System.out.println("ingrese el nuevo mes (1-12): ");
					String entrada= scanner.nextLine();
					try {
						mes = Integer.parseInt(entrada);
						if(mes>=1 && mes<=12) {
							break;
						}else {
							System.out.println("ingrese una opcion valida (1-12)");
						}
					}catch(Exception e) {
						System.out.println("ingrese solo numeros");
					}
				}
				while(true) {
					System.out.println("ingrese el nuevo año: ");
					String entrada = scanner.nextLine();
					try {
						año = Integer.parseInt(entrada);
						if(año>= 1 && año<= 12) {
							break;
						}else {
							System.out.println("Ingrese una opcion valida (1-12)");
						}
					}catch(Exception e) {
						System.out.println("Ingrese solo numeros");
					}
				}
				
				String FechaNueva = dia+"/"+mes+"/"+año;
				
				String LineaNueva = Usuario+";"+FechaNueva+";"+partes[2]+";"+partes[3];
				for(int i = 0;i<lineasR.length;i++) {
					if(lineasR[i].equals(seleccionada)) {
						lineasR[i] = LineaNueva;
						fechas[i] = FechaNueva;
						dias[i]= String.valueOf(dia);
						meses[i]= String.valueOf(mes);
						años[i]=String.valueOf(año);
					}
				}
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoR))){
					for(int i = 0;i<lineasR.length;i++) {
						bw.write(lineasR[i]);
						bw.newLine();
					}
				}catch (Exception e) {
					System.out.println("Error al guardar");
				}
				break;
			case 2:
				int duracionNueva;
				while(true) {
					
					System.out.println("cual es la nueva duracion (1-23): ");
					String entrada = scanner.nextLine();
					
					try {
						duracionNueva = Integer.parseInt(entrada);
						if(duracionNueva>= 1 && duracionNueva<= 23) {
							break;
						}else {
							System.out.println("ingrese una opcion valida");
						}
					}catch (Exception e) {
						System.out.println("ingrese solo numeros");
					}
				}
				
				 LineaNueva = Usuario+";"+partes[1]+";"+duracionNueva+";"+partes[3];
				 for(int i = 0;i<lineasR.length;i++) {
					 if(lineasR[i].equals(seleccionada)) {
						 lineasR[i] = LineaNueva;
						 Horas[i]=duracionNueva;
					 }
				 }
				 try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoR))){
					 for(int i = 0;i<lineasR.length;i++) {
						 bw.write(lineasR[i]);
					 }
				 }catch(Exception e) {
					 System.out.println("error al guardar");
				 }
				 break;
			case 3:
				String Actividad;
				while(true) {
					System.out.println("ingrese la actividad");
					Actividad = scanner.nextLine();
					if(Actividad.equals(" ")) {
						break;
					}else {
						System.out.println("La actividad no puede estar vacia");	
					}
				}
				
				LineaNueva = Usuario+";"+partes[1]+";"+partes[2]+";"+Actividad;
				for(int i = 0;i<lineasR.length;i++) {
					if(lineasR[i].equals(seleccionada)) {
						lineasR[i] = LineaNueva;
						Actividades[i] = Actividad;
					}
				}
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoR))){
					 for(int i = 0;i<lineasR.length;i++) {
						 bw.write(lineasR[i]);
					 }
				 }catch(Exception e) {
					 System.out.println("erro al guardar");
				 }
				break;
			}
			
		}while(opcion != 0);
		System.out.println("se ha modificado la actividad");
		
	}
}

		
	
	