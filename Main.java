// Importes
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Declaramos el scanner
    Scanner scanner = new Scanner(System.in);
    
    String nombreHospital = "";

    // Solicitamos al usuario proveer un nombre para el hospital para instanciar la clase Sistema
    do {
      System.out.print("\nIngresa un nombre para el Hospital: ");
      nombreHospital = scanner.nextLine();

      if (nombreHospital.isEmpty()) {
        System.out.println("ERROR: no se ingresó nada, intenta de nuevo");
      }
    } while (nombreHospital.isEmpty());

    // Instanciamos la clase
    Sistema hospital = new Sistema(nombreHospital);

    // Instanciamos objetos
    Medico medico1 = new Medico("Andres", "12458798", "Cardiología");
    Medico medico2 = new Medico("Carlos", "32346098", "Cardiología");
    Enfermero enfermero1 = new Enfermero("Pablo", "9956789", "Cardiología");
    Enfermero enfermero2 = new Enfermero("Dante", "89725410", "Cardiología");
    Paciente paciente1 = new Paciente("Juan", "Cardiología");
    Paciente paciente2 = new Paciente("Ana", "Cardiología");

    // MÉTODOS 

    System.out.println("\nMÉTODOS DE REGISTRO\n");

    medico1.registroEnSistema(hospital);
    enfermero1.registroEnSistema(hospital);
    paciente1.registroEnSistema(hospital);
    
    // Directamente desde el sistema
    hospital.registroMedico(medico2);
    hospital.registroEnfermero(enfermero2);
    hospital.registroPaciente(paciente2);

    System.out.println("\nGETTERS DE CONSULTA DE DATOS DEL SISTEMA\n");

    System.out.println("Número de Médicos: " + hospital.getNoMedicos());
    System.out.println("Médicos: " + hospital.getMedicos());
    System.out.println("Número de Enfermeros: " + hospital.getNoEnfermeros());
    System.out.println("Enfermeros: " + hospital.getEnfermeros());
    System.out.println("Número de Pacientes: " + hospital.getNoPacientes());
    System.out.println("Pacientes: " + hospital.getPacientes());

    System.out.println("\nINFORMACIÓN PACIENTES\n");

    for (Paciente paciente : hospital.getPacientes()) {
        paciente.solicitarConsulta();
        System.out.println("Nombre del paciente: " + paciente.getNombre() + " | Especialidad requerida del paciente: " + paciente.getEspecialidadAtencion());
    }
    
    System.out.println("\nASIGNACIÓN MÉDICOS/ENFERMEROS A PACIENTES\n");    

    hospital.asignarPaciente(paciente1, enfermero1);
    hospital.asignarPaciente(paciente2, enfermero2);
    hospital.asignarPaciente(paciente1, medico1);
    hospital.asignarPaciente(paciente2, medico2);

    System.out.println("\nMÉTODOS Y GETTER DE MÉDICOS/ENFERMEROS\n");

    // Médicos    
    System.out.println("Nombre de Médico 1: " + medico1.getNombre());
    System.out.println("Cedula de Médico 1: " + medico1.getCedula());
    System.out.println("Especialidad de Médico 1: " + medico1.getEspecialidad());
    System.out.println("Número de pacientes del Médico 1: " + medico1.getNoPacientes());
    medico1.solicitarPaciente();
    medico1.verListaPacientes();

    // Enfermeros
    System.out.println("Nombre de Enfermero 1: " + enfermero1.getNombre());
    System.out.println("Cedula de Enfermero 1: " + enfermero1.getCedula());
    System.out.println("Especialidad de Enfermero 1: " + enfermero1.getEspecialidad());
    System.out.println("Número de pacientes del Enfermero 1: " + enfermero1.getNoPacientes());
    medico1.verListaPacientes();

    System.out.println("\nFLUJO CONSULTA Y TRATAMIENTO\n");

    // 1. Primero se consulta el estado del paciente
    paciente1.verConsulta();
    paciente1.verTratamiento();

    // 2. Luego se le da consulta al paciente
    medico1.darConsulta(paciente1);
    paciente1.verConsulta();

    // 3. Y procede a dársele tratamiento
    medico1.darTratamiento(paciente1);

    // 2. Alternativamente el enfermero le proporciona medicina directamente
    enfermero1.darTratamiento(paciente2);

    scanner.close();
  }
}
