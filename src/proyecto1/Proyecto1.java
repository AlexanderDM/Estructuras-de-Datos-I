package proyecto1;

import javax.swing.JOptionPane;

public class Proyecto1 {

    public static void main(String[] args) {        
        
        ListaDoble estudiantes = new ListaDoble("Estudiantes");
        int v_opcion = 0;
        float nota = 0;
        String str_nota = "";
        String nombre = "";
        
        do {
            try {
                v_opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. INGRESAR ESTUDIANTE Y NOTA AL INICIO \n"
                        + "2. INGRESAR ESTUDIANTE Y NOTA AL FINAL \n"
                        + "3. INGRESAR ESTUDIANTE Y NOTA EN POSICIÓN X \n"
                        + "4. IMPRIMIR LISTA HACIA ADELANTE \n"
                        + "5. IMPRIMIR LISTA HACIA ATRÁS \n"
                        + "6. IMPRESIÓN DEL ESTUDIANTE EN POSICIÓN X \n"
                        + "7. BORRAR ESTUDIANTE Y NOTA \n"
                        + "8. SALIR \n\n"
                        + "  ------> Seleccione la opcion deseada", "Menu de opciones",
                        JOptionPane.INFORMATION_MESSAGE));
                switch (v_opcion) {
                    case 1: //INGRESAR ESTUDIANTE Y NOTA AL INICIO
                        try{
                            nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del estudiante", "Ingreso de estudiante",JOptionPane.INFORMATION_MESSAGE);
                            str_nota = (JOptionPane.showInputDialog(null, "Ingrese la nota del estudiante", "Nota",JOptionPane.INFORMATION_MESSAGE));   
                            nota = Float.parseFloat(str_nota);
                            NodoListaDoble nuevo = new NodoListaDoble(nombre, nota);
                            estudiantes.InsertaInicio(nuevo);
                            estudiantes.ImprimirAdelante();                        
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,
                                "Entrada no válida", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 2: //INGRESAR ESTUDIANTE Y NOTA AL FINAL
                        try{
                            nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del estudiante", "Ingreso de estudiante",JOptionPane.INFORMATION_MESSAGE);
                            str_nota = (JOptionPane.showInputDialog(null, "Ingrese la nota del estudiante", "Nota",JOptionPane.INFORMATION_MESSAGE));   
                            nota = Float.parseFloat(str_nota);
                            NodoListaDoble nuevo = new NodoListaDoble(nombre, nota);
                            estudiantes.InsertaFinal(nuevo);
                            estudiantes.ImprimirAdelante();                        
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,
                                "Entrada no válida", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                        }                         
                        break;

                    case 3: //INGRESAR ESTUDIANTE Y NOTA EN POSICIÓN X
                        try{
                            int pos = 0;
                            String str_pos = "";
                            nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del estudiante", "Ingreso de estudiante",JOptionPane.INFORMATION_MESSAGE);
                            str_nota = (JOptionPane.showInputDialog(null, "Ingrese la nota del estudiante", "Nota",JOptionPane.INFORMATION_MESSAGE));   
                            nota = Float.parseFloat(str_nota);
                            str_pos = (JOptionPane.showInputDialog(null, "Ingrese la posición deseada", "Nota",JOptionPane.INFORMATION_MESSAGE));                               
                            pos = Integer.parseInt(str_pos);
                            NodoListaDoble nuevo = new NodoListaDoble(nombre, nota);
                            if (0 < pos && pos <= estudiantes.largo()){
                                estudiantes.InsertaPosicion(nuevo, pos);
                                estudiantes.ImprimirAdelante();                        
                            }else{
                                JOptionPane.showMessageDialog(null,
                                "Entrada no válida", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                            }                            
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,
                                "Entrada no válida", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                        } 
                        break;
                    case 4: //IMPRIMIR LISTA HACIA ADELANTE                        
                        JOptionPane.showMessageDialog(null, estudiantes.ImprimirAdelante(),
                            "Mostrando lista de inicio a fin ", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5: //IMPRIMIR LISTA HACIA ATRÁS
                        JOptionPane.showMessageDialog(null, estudiantes.ImprimirAtras(),
                            "Mostrando lista de fin a inicio ", JOptionPane.INFORMATION_MESSAGE);                        
                        break;
                    case 6: //IMPRESIÓN DEL ESTUDIANTE EN POSICIÓN X                         
                        int pos = 0;
                        String str_pos = "";                            
                        str_pos = (JOptionPane.showInputDialog(null, "Ingrese la posición que desea consultar", "Posición",JOptionPane.INFORMATION_MESSAGE));                               
                        pos = Integer.parseInt(str_pos);
                        if (0 < pos && pos <= estudiantes.largo()){
                            JOptionPane.showMessageDialog(null, 
                                "Impresión del estudiante en posición X "+estudiantes.imprimirElementoPos(pos), "Posición", 
                                JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,
                                "La posición ingresada no es válida", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7: //BORRAR ESTUDIANTE Y NOTA 
                        int pos_borr = 0;
                        String str_pos_borr = "";                            
                        str_pos_borr = (JOptionPane.showInputDialog(null, "Ingrese la posición que desea Borrar", "Posición",JOptionPane.INFORMATION_MESSAGE));
                        pos_borr = Integer.parseInt(str_pos_borr);
                        if (0 < pos_borr && pos_borr <= estudiantes.largo()){
                            estudiantes.borrarElementoPos(pos_borr);
                            JOptionPane.showMessageDialog(null, 
                                "Borrado el estudiante en posición "+ pos_borr, "Posición", 
                                JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,
                                "La posición ingresada no es válida", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 8: //SALIR
                        JOptionPane.showMessageDialog(null,
                                "Aplicación finalizada", "FIN",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,
                                "La opción ingresada no es válida", "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            }
        } while (v_opcion != 8);       
    }
}
