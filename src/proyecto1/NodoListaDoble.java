package proyecto1;

// Clase NodoListaDoble
class NodoListaDoble {
    String nombre;    
    float nota;
    NodoListaDoble anterior, siguiente;

//Construtor  
    NodoListaDoble() {        
        siguiente = null;  //siguiente con coordenadaX de nulo
    }
    
    NodoListaDoble(String nombre, float pNota) {
        this.nombre = nombre;
        this.nota = pNota;
        this.siguiente = null;  //siguiente nulo
    }

// Constructor Crea un nodo y al siguiente nodo de la lista
    NodoListaDoble(NodoListaDoble signodo) {        
        siguiente = signodo; //siguiente se refiere al siguiente nodo
    }
}
