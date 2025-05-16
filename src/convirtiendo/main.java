package convirtiendo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        conversor conversor = new conversor();
        boolean salir = false;
        boolean valido = true;
        String monedaOrigen = "";
        String monedaDestino = "";
        int opcion;
        float cantidad = 0;
        float resultado = 0;

        try {
            while(!salir){
                System.out.print("=== Convertidor de monedas ===\n" +
                        "1) USD -> CLP\n" +
                        "2) CLP -> BOB\n" +
                        "3) CLP -> ARS\n" +
                        "4) Salir\n" +
                        "Elija opción:");
                opcion = scanner.nextInt();
                valido = true;
                switch (opcion){
                    case 1:
                        monedaOrigen = "USD";
                        monedaDestino = "CLP";
                        break;
                    case 2:
                        monedaOrigen = "CLP";
                        monedaDestino = "BOB";
                        break;
                    case 3:
                        monedaOrigen = "CLP";
                        monedaDestino = "ARS";
                        break;
                    case 4:
                        salir = true;
                        valido = false;
                        break;
                    default:
                        valido = false;
                        System.out.println("Opción no válida");
                }
                if(valido){
                    System.out.print("Ingrese la cantidad: ");
                    cantidad = scanner.nextFloat();
                    resultado = conversor.convertir(monedaOrigen,monedaDestino,cantidad);
                    System.out.println(cantidad+""+monedaOrigen+" = "+resultado+""+monedaDestino);
                }
            }

        } catch (Exception e) {
            System.out.println("¡Error! " + e.getMessage());
        }

        scanner.close();
    }
}
