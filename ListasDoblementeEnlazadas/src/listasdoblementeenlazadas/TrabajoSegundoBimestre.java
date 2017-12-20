package listasdoblementeenlazadas;

import java.util.Scanner;

/**
 *
 * @author jahurtadod
 */
public class TrabajoSegundoBimestre {

    //Se crea la cabeza y cola
    private Nodo head, tail;
    private static Scanner input = new Scanner(System.in);

    //Constructor
    public TrabajoSegundoBimestre() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TrabajoSegundoBimestre def = new TrabajoSegundoBimestre();
        int opt;

        do {
            System.out.print(menuPrincipal());
            opt = input.nextInt();

            switch (opt) {
                case 1:
                    def.addNodoInicio(def.pedirValorNodo());
                    break;
                case 2:
                    def.addNodoFinal(def.pedirValorNodo());
                    break;
                case 3:
                    def.addNodoOrdenado(def.pedirValorNodo());
                    break;
                case 4:
                    System.out.println(def.deleteNodo(def.pedirValorNodo()));
                    break;
                case 5:
                    def.printFromHead();
                    break;
                case 6:
                    def.printFromTail();
                    break;
            }
        } while (opt != 0);
        System.out.println("Finalizando........");

    }

    public static String menuPrincipal() {
        // Menu principal
        return String.format(
                "\n\tMENU - LISTAS DOBLEMENTE ENLAZADAS\n"
                + "INGRESE EL NUMERO DE LA OPCION\n"
                + "1. Ingresar Nuevo Nodo - Inicio de la Lista.\n"
                + "2. Ingresar Nuevo Nodo - Final de la Lista.\n"
                + "3. Ingresar Nuevo Nodo - Posición Correspondiente.\n"
                + "4. Eliminar Nodo de la Lista\n"
                + "5. Recorrer la Lista desde Head\n"
                + "6. Recorrer la Lista desde Tail\n"
                + "0. Salir...\n"
                + (char) 27 + "[34m----> ");
    }

    public void addNodoInicio(int valor) {
        Nodo newNodo = new Nodo(valor);
        if (this.head == null) {
            this.head = newNodo;
            this.tail = newNodo;
        } else {
            // Ubicamos al nuevo Nodo como nueva cabeza
            newNodo.sig = this.head;
            this.head.ant = newNodo;
            this.head = newNodo;
        }
    }

    public void addNodoFinal(int valor) {
        Nodo newNodo = new Nodo(valor);
        if (this.tail == null) {
            this.head = newNodo;
            this.tail = newNodo;
        } else {
            //Ubicamos al nuevo Nodo como nueva Cola
            newNodo.ant = this.tail;
            this.tail.sig = newNodo;
            this.tail = newNodo;
        }
    }

    public void addNodoOrdenado(int valor) {
        Nodo newNodo = new Nodo(valor);
        Nodo actual;

        // Cuando no se tiene valores
        if (this.head == null) {
            this.head = newNodo;
            this.tail = newNodo;
        } else {
            // Cuando el valor ingresado es menor a la cabeza
            if (this.head.valor >= newNodo.valor) {
                newNodo.sig = this.head;
                this.head.ant = newNodo;
                this.head = newNodo;
            } else {
                actual = this.head;
                // Se busca al Nodo que apuntara al nuevo Nodo
                while (actual.sig != null && actual.sig.valor < newNodo.valor) {
                    actual = actual.sig;
                }
                // Insertamos al nuevo Nodo 
                newNodo.sig = actual.sig;
                if (actual.sig != null) {
                    newNodo.sig.ant = newNodo;
                } else {
                    this.tail = newNodo;
                }
                actual.sig = newNodo;
                newNodo.ant = actual;
            }
        }
    }

    public String deleteNodo(int valor) {
        Nodo actual = this.head;
        // Se considera si se elimina la cabeza
        if (this.head.valor == valor) {
            if (this.head.sig == null) {
                this.head = this.tail = null;
            } else {
                this.head = this.head.sig;
                this.head.ant = null;
            }
            return "Nodo eliminado (Posición Inicial)";
        } else {
            // Si se elimina la cola
            if (this.tail.valor == valor) {
                this.tail = this.tail.ant;
                this.tail.sig = null;
                return "Nodo eliminado (Posición Final)";
            } else {
                // Si es un valor intermedio
                while (actual.sig != this.tail) {
                    if (actual.sig.valor == valor) {
                        actual.sig = actual.sig.sig;
                        actual.sig.ant = actual;
                        return "Nodo eliminado (Posición Intermedia)";
                    }
                    actual = actual.sig;
                }
                return "Nodo no eliminado (No existe Nodo con ese valor)";
            }
        }
    }

    public void printFromHead() {
        Nodo actual = this.head;
        // Muestra la lista de color azul para poder indentificarla mas facil
        System.out.print((char) 27 + "[34m   null ");
        while (actual != null) {
            System.out.print("<- [" + actual.valor + "] ->");
            actual = actual.sig;
        }
        System.out.println(" null");
    }

    public void printFromTail() {
        Nodo actual = this.tail;
        // Muestra la lista de color azul para poder indentificarla mas facil
        System.out.print((char) 27 + "[34m   null ");
        while (actual != null) {
            System.out.print("<- [" + actual.valor + "] ->");
            actual = actual.ant;
        }
        System.out.println(" null");
    }

    public int pedirValorNodo() {
        int valor;
        System.out.print("   Ingrese el valor del Nodo : ");
        valor = input.nextInt();
        return valor;
    }

    public static class Nodo {
        //Atributos
        public int valor;
        public Nodo sig, ant;
        // Constructor
        public Nodo(int valor) {
            this.valor = valor;
            this.sig = null;
            this.ant = null;
        }
    }
}
