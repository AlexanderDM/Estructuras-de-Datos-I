package proyecto1;

//Definicion de la Clase de Excepciones
class EmptyListException  extends RuntimeException
{ public EmptyListException(String nombre)
  {
	  super ( " La" + nombre+" esta vacia");
  }
 }

//Definici�n de la Clase Lista
public class ListaDoble {

    public NodoListaDoble PrimerNodo;
    public NodoListaDoble UltimoNodo;
    String nombre_lista;

    //Constructor construye una lista vacia con un nombre s
    //Retorna True si Lista Vac�a
    public boolean VaciaLista() {
        return PrimerNodo == null;
    }

    // Imprime el contenido de la lista
    public void Imprimir() {
        System.out.println("\tImprimir Lista");
        if (VaciaLista()) {
            System.out.println("La lista " + nombre_lista + " está vacía.\n\n");
        }
        else {
            //System.out.print("La  " + nombre_lista + "  es:  ");
            System.out.print("La lista " + nombre_lista + "  es:  ");
            NodoListaDoble Actual = PrimerNodo;

            while (Actual != null) {                
                System.out.println("\t Nombre: "+ Actual.nombre + "\t Nota: " + Actual.nota);                
                Actual = Actual.siguiente;
            }
            System.out.println("\n\n");
        }
    }
    
    // Imprime el contenido de la lista
    public String ImprimirAdelante() {
        System.out.println("\tImprimir Lista hacia Adelante");
        String lista = "";
        if (VaciaLista()) {
            System.out.println("La lista " + nombre_lista + " está vacía.\n\n");
            lista = "La lista " + nombre_lista + " está vacía.\n\n";
        }
        else {
            //System.out.print("La  " + nombre_lista + "  es:  ");
            System.out.println("La lista " + nombre_lista + "  es:  ");
            lista += "La lista " + nombre_lista + "  es:  \n";
            NodoListaDoble Actual = PrimerNodo;

            while (Actual != null) {                
                System.out.println("\t Nombre: "+ Actual.nombre + "\t Nota: " + Actual.nota);
                lista += "\n" + "\t Nombre: "+ Actual.nombre + "\t Nota: " + Actual.nota + " ";
                Actual = Actual.siguiente;
            }
            System.out.println("\n\n");
        }
        return lista;
    }
    
    // Imprime el contenido de la lista
    public String ImprimirAtras() {
        System.out.println("\tImprimir Lista hacia Atrás");
        String lista = "";
        if (VaciaLista()) {
            System.out.println("La lista " + nombre_lista + " está vacía.\n\n");
            lista = "La lista " + nombre_lista + " está vacía.\n\n";
        }
        else {            
            System.out.println("La lista " + nombre_lista + "  es:  ");
            lista += "La lista " + nombre_lista + "  es:  \n";
            NodoListaDoble Actual = UltimoNodo;

            while (Actual != null) {                
                System.out.println("\t Nombre: "+ Actual.nombre + "\t Nota: " + Actual.nota);                
                lista += "\n" + "\t Nombre: "+ Actual.nombre + "\t Nota: " + Actual.nota + " ";
                Actual = Actual.anterior;
            }
            System.out.println("\n\n");
        }
        return lista;
    }

    public ListaDoble(String s) {
        nombre_lista = s;
        PrimerNodo = UltimoNodo = null;
    }

//Constructor construye una lista vacia con un nombre de List
    public ListaDoble() {
        this("Lista");
    }

//Inserta al Final de la Lista
//Si la lista se encuentra vac�a, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo.
    public void InsertaFinal() {
        if (VaciaLista()) {
            PrimerNodo = UltimoNodo = new NodoListaDoble();            
        } else {
            UltimoNodo = UltimoNodo.siguiente = new NodoListaDoble();
        }
    
    }
    //Insertar Estudiante al inicio de la lista
    public void InsertaInicio(NodoListaDoble estudiante) {
        if (VaciaLista()) {
            PrimerNodo = UltimoNodo = estudiante;
        } else {
            estudiante.siguiente = PrimerNodo;
            PrimerNodo.anterior = estudiante;
            PrimerNodo = estudiante;
        }
    }
    
    //Insertar Estudiante al final de la lista
    public void InsertaFinal(NodoListaDoble estudiante) {
        if (VaciaLista()) {
            PrimerNodo = UltimoNodo = estudiante;
        } else {
            estudiante.anterior = UltimoNodo;
            UltimoNodo.siguiente = estudiante;
            UltimoNodo = estudiante;
        }
    }
    
    //Insertar Estudiante en la posición indicada a la lista
    public void InsertaPosicion(NodoListaDoble estudiante, int pos) {
        NodoListaDoble actual = null;
        int largo = largo();
        if (VaciaLista() || pos > largo || pos <= 0) {
            //Decidir si es un error o siempre dejarlo ingresar?
            System.out.println("La posición de la lista indicada no existe, se ingresará el elemento en la posición 1"); 
            PrimerNodo = UltimoNodo = estudiante;
            return;
        }
        
        if(pos <= largo){
            //actual = buscarElementoId(pos);
            actual = obtenerElementoPos(pos);
            
            if(actual == null || actual.siguiente == null){ //inserta al final
                //InsertaFinal(estudiante);                
                estudiante.anterior = UltimoNodo.anterior;
                UltimoNodo.anterior.siguiente = estudiante;
                estudiante.siguiente = UltimoNodo;
                UltimoNodo.anterior = estudiante;
            }else{
                if(largo==1){
                    InsertaInicio(estudiante);
                }else{
                    estudiante.anterior = actual.anterior;
                    actual.anterior.siguiente = estudiante;
                    actual.anterior = estudiante;
                    estudiante.siguiente = actual;
                }
            }   
        }        
    }        

    //BuscarElemento en lista
    public void buscarElemento(int Elem) {
        try {
            NodoListaDoble aux = PrimerNodo;
            //while ((aux != null) & (aux.y != Elem)) {
            while ((aux != null)) {
                aux = aux.siguiente;
            }
            if (aux != null) {
                System.out.println("Elemento si se encuentra");
            }
        } catch (Exception e) {
            System.out.println("Elemento no se encuentra");;
        }
    }
    //Eliminar Elemento en una lista usando el id como posición
    //Se asume que las posiciones empiezan desde 1 y no desde 0
    public NodoListaDoble obtenerElementoPos(int pos) {
        NodoListaDoble aux = PrimerNodo;
        int largo = largo();
        
        try {            
            if(VaciaLista() || pos <= 0 || pos > largo ){
                System.out.println("\tError: La posición especificada no existe.");
            }
            for (int i=0; i < largo; i++){ 
                if(i == pos - 1){
                    break;
                }else{
                    aux = aux.siguiente;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Elemento no se encuentra");
            return null;
        }
        return aux;
    }
    //Se asume que las posiciones empiezan desde 1 y no desde 0
    public String imprimirElementoPos(int pos) {
        String elemento = "";
        NodoListaDoble aux = PrimerNodo;
        int largo = largo();
        
        try {            
            if(VaciaLista() || pos <= 0 || pos > largo ){
                System.out.println("\tError: La posición especificada no existe.");
                elemento = "La lista " + nombre_lista + " está vacía.\n\n";                
            }
            for (int i=0; i < largo; i++){ 
                if(i == pos - 1){
                    break;
                }else{
                    aux = aux.siguiente;
                }
            }
            elemento = "\n" + "\t Nombre: "+ aux.nombre + "\t Nota: " + aux.nota + " ";
        } catch (Exception e) {
            System.out.println("Error: Elemento no se encuentra");
            return null;
        }
        return elemento;
    }
    
    //Eliminar Elemento en una lista usando el id como posición
    //Se asume que las posiciones empiezan desde 1 y no desde 0
    public void borrarElementoPos(int pos) {
        System.out.println("\tElimnar elemento de posición "+ pos);
        NodoListaDoble aux = PrimerNodo;
        int largo = largo();
        
        try {            
            if(VaciaLista() || pos <= 0 || pos > largo ){
                System.out.println("\tError: La posición especificada no existe.");
            }
            for (int i=1; i < largo + 1; i++){ 
                if(i == pos ){
                    if(largo == 1){
                        PrimerNodo = UltimoNodo = null;
                        aux = null;
                    }else{
                        if(aux.siguiente != null && aux.anterior == null){
                            if(aux == PrimerNodo){
                                aux.siguiente.anterior = null;
                                PrimerNodo = aux.siguiente;                                
                                aux = null;
                            }else{
                                aux.siguiente.anterior = null;
                                aux = null;
                            }                            
                        }else{
                            if(aux.siguiente == null){
                                UltimoNodo = aux.anterior;
                                aux.anterior.siguiente = null;
                            }else{
                                if(aux.siguiente != null){
                                    aux.anterior.siguiente = aux.siguiente;
                                    aux.siguiente.anterior = aux.anterior;
                                    aux = null;
                                }                                
                            }
                        }                        
                    }                    
                }
                aux = aux.siguiente;
            }
        } catch (Exception e) {
            System.out.println("Error: Elemento no se encuentra");
            return;
        }
        return;
    }
    
    public int largo() {
        NodoListaDoble aux = this.PrimerNodo;
        int i = 0;
        
        if(VaciaLista()){
            return i;
        }        
        if (aux.siguiente == null) {
            i = 1;            
        }
        else{
            while (aux.siguiente != null) {
                i += 1;
                aux = aux.siguiente;
            }
            i += 1;
        }
        System.out.println("Largo de la lista: \t" + i);
        return i;
    }
}
