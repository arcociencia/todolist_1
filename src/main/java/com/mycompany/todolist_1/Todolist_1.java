/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist_1;
import javax.swing.*; /*Importacion completa del paquete de clases de la
interfaz grafica de Java Swing.*/
import java.awt.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Todolist_1 {

    public static void main(String[] args) {
        
        //CREAR LA VENTANA
        JFrame frame = new JFrame("Gestion de tareas"); /*JFrame es una clase que pertenece a Java Swing.
        Representa un contenedor donde se alojan componentes, botones, campos de texto, etiquetas, etc.*/
        
        /*frame es el nombre de una variable. Es una variable del tipo JFrame. Es para que refiera al objeto
        que acabamos de crear*/
        
        /*new Es una palabra clave en Java que crea un nuevo objeto en memoria*/
        
        /*JFrame("Gestion de tareas")llama al constructor de la clase JFrame que acepta un titulo como argumento*/
        
        /*La referencia a esta ventana se guardara en memoria en la varible frame*/
        
        /*Al escribir new JFrame("Gestión de Tareas"), estás invocando al constructor de la clase JFrame.
        Luego el constructor crea un objeto y tú decides llamarlo frame al asignarlo a esa variable*/
        
        //CONFIGURAR LA VENTANA
        frame.setSize(400,300); //Establece el tamano de la ventana (ancho x alto).
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*cierra la aplicacion al cerrar la ventana.
        Indica que la aplicación debe cerrarse completamente cuando el usuario cierra la ventana.
        Sin esto, la ventana podría cerrarse, pero la aplicación seguiría ejecutándose en segundo plano.*/
        
        
        //CREAR EL CAMPO DE TEXTO Y EL BOTON
        JTextField textField = new JTextField(20);//crea un campo de texto donde el usuario podrá escribir algo.No le hemos puesto un texto inicial (por eso está vacío), pero se puede agregar texto por defecto si se quiere, como new JTextField("Escribe aquí...");
        JButton addButton = new JButton("Agregar tarea");//JButton addButton = new JButton("Agregar Tarea"); crea un botón con el texto "Agregar Tarea".El botón todavía no hace nada cuando se hace clic, pero lo podemos programar más adelante para que realice alguna acción, como agregar tareas a una lista.
        JButton saveButton = new JButton("Guardar tareas");
        
        //CREAR UN JTEXTAREA PARA MOSTRAR LA LISTA DE LAS TAREAS
        JTextArea taskList = new JTextArea(10,30);//se crea un objeto del tipo JTextArea llamado taskList de 10 filas y 30 columnas
        taskList.setEditable(false); //Llamamos al método setEditable(false) para evitar que el usuario pueda escribir directamente en esta área.Esto es importante porque el área de texto es solo para mostrar las tareas, y no para que las edite.
        
        
        
        //CREAR UN ACTIONLISTENER PARA EL BOTON USANDO LAMBDA PARA MANEJAR EL CLIC EN EL BOTON
        //este paso es importante ya que le estamos indicando al sistema que hacer cuando el usuario de click en el boton.
        addButton.addActionListener(e -> { //addActionListener es un método de la clase JButton. Como addButton es parte de la familia JButton puede ocupar los metodos de esa clase.
            /*Por su parte e es el parametro que representa el evento. Contiene informacion del evento ocurrido, en este caso el boton que fue presionado.*/
            // -> quiere decir "cuando ocurra el evento 'e' ejecuta el bloque de codigo dentro de las llaves {}".
            String tarea = textField.getText(); //captura el texto del campo. "Pasame lo que el usuario escribio en el JTextField llamado textField. Almacenalo en esta variable 'tarea' de tipo String"
            if (!tarea.isEmpty()){ //Se verifica que 'tarea' no este vacio (pero por que???)
                //isEmpty() es un método de la clase String en Java. Su función es verificar si una cadena de texto (String) está vacía.
            /*Retorna:
true: Si el texto está vacío (es decir, no contiene caracteres).
false: Si la cadena contiene al menos un carácter.
                
                El operador ! es un NOT lógico en Java. Invierte el valor lógico de una condición:
Si una condición es true, al aplicarle !, se convierte en false.
Si una condición es false, al aplicarle !, se convierte en true.
Por lo tanto:

tarea.isEmpty() significa: "¿La cadena está vacía?".
!tarea.isEmpty() significa: "¿La cadena NO está vacía?".
                
                
                */                                                               
                
            taskList.append(tarea + "\n"); // "Agregame en taskList del tipo JTextArea lo que hay en tarea y pegate un salto de linea." Se nade append para anadir la tarea, funcion propia de JTextArea. Y obviamente un salto de linea para situarse en la siguiente linea.
            
            
            textField.setText(""); //Limpia el campo de texto despues de agregar la tarea.                           
        } else { //Si el campo está vacío, mostramos una ventana emergente con un mensaje de advertencia usando JOptionPane.
                
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese una tarea", "Advertencia", JOptionPane.WARNING_MESSAGE);
                
                
                }                                                                           
        
    });                    
        
        
        
        //ACCION AL CLIC DEL BOTÓN "Guardar tareas"
        saveButton.addActionListener(e -> guardarTareas(taskList.getText()));
        
        
        
        
        
        
        
        
        //AGREGAR Y EL CAMPO DE TEXTO Y EL BOTON A LA VENTANA (PANEL)
        frame.setLayout(new FlowLayout());//establece el tipo de layout (diseño) que queremos para los componentes dentro de la ventana.
        //FlowLayout coloca los componentes en una fila, de izquierda a derecha.Si agregamos más componentes, se agregarán de manera secuencial.
        frame.add(textField);//Agregar el campo de texto
        frame.add(addButton);//Agregar el boton        
        //agregan el campo de texto y el botón a la ventana, para que aparezcan.
        frame.add(saveButton);
        
        
        //AGREGAR EL JTEXTAREA AL JFRAME       
        frame.add(new JScrollPane(taskList));//El JScrollPane es un contenedor que permite añadir barras de desplazamiento (scroll) automáticamente si el contenido del JTextArea excede el espacio visible.
        //Aquí estamos añadiendo el taskList (el área de texto) dentro de un JScrollPane.
        //frame.add quiere decir que estamos añadiendo el JScrollPane al JFrame para que el área de texto se muestre en nuestra interfaz.
        
        
        
        
        
        
        
        
        
        //HACER VISIBLE LA VENTANA
        frame.setVisible(true); //hace visible la ventana.Sin esta línea, aunque crees el objeto JFrame, la ventana no aparecerá en la pantalla.
        
        

    
    }
    
    
    public static void guardarTareas(String tareas) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar Tareas");

    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        // Obtener el archivo seleccionado
        java.io.File fileToSave = fileChooser.getSelectedFile();

        // Asegurarse de que el archivo termine en ".txt"
        if (!fileToSave.getName().endsWith(".txt")) {
            fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".txt");
        }

        // Guardar las tareas en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
            writer.write(tareas);
            JOptionPane.showMessageDialog(null, "Tareas guardadas exitosamente", "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar las tareas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    
    
   }
    
    
    
    
    
    
    
