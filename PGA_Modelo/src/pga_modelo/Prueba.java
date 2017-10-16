package pga_modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import pga_xml.SerializadorXML;

public class Prueba {
    public static void main(String[] args) {
        Entidades entidades = new Entidades();
        SerializadorXML serializador;
        serializador = new SerializadorXML();
        
        Alumno alumnoA = new Alumno("ALU0003", "Jose Perez", "Juan B Justo 2050", "jperez@gmail.com");
        Alumno alumnoB = new Alumno("ALU0041", "Maria Funes", "Santa Fe 1234", "mfunes@gmail.com");
        Alumno alumnoC = new Alumno("ALU0352", "Lucas Torres", "9 de Julio 1530", "ltorres@gmail.com");
        entidades.addAlumno(alumnoA);
        //entidades.addAlumno(alumnoB);
        //entidades.addAlumno(alumnoC);
        
        Profesor profesorA = new Profesor("PRO0013", "Leonel Guccione", "Calle Falsa 123", "2235 123593", "leo@copetel.com.ar");
        Profesor profesorB = new Profesor("PRO0054", "Adolfo Tomas Spinelli", "Calle Siempreviva 567", "2234 423585", "adolfspin@gmail.com");
        Profesor profesorC = new Profesor("PRO0793", "Guillermo Lazzurri", "Calle Verdadera 940", "2236 078934", "guillelazurr@live.com");
        //entidades.addProfesor(profesorA);
        //entidades.addProfesor(profesorB);
        //entidades.addProfesor(profesorC);

        try {
            serializador.escribe(entidades, "archivodePruebas.xml");
        } catch (Exception e) {
            
        }
    }
}
