import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Enfermero {

  private String nombre;
  private String cedula;
  private String especialidad;
  private int noPacientes;

  // Lista de pacientes siendo cuidados
  private List<Paciente> listaPacientes;

  // Constructor
  public Enfermero(String nombre, String cedula, String especialidad) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.especialidad = especialidad;
    this.noPacientes = 0;
    this.listaPacientes = new ArrayList<>();
  }

  // GETTERS

  // Get que retorna el nombre
  public String getNombre() {
    return nombre;
  }

  // Get que retorna la especialidad
  public String getEspecialidad() {
    return especialidad;
  }

  // Get que retorna el número de pacientes
  public int getNoPacientes() {
    return noPacientes;
  }

  // Get que retorna la cédula del enfermero
  public String getCedula() {
    return cedula;
  }

  // MÉTODOS

  // Método que registra todo el objeto Enfermero llamando al método 'registroEnfermero' del sistema con el objeto entero como argumento
  public void registroEnSistema(Sistema sistema) {
    sistema.registroEnfermero(this);
  }

  // Se agrega paciente a la lista de pacientes siendo cuidados
  public void agregarPaciente(Paciente paciente) {
    // SSi el Enfermero tiene menos pacientes que su máximo de 3, se agrega a la lista
    if (this.noPacientes < 3) {
      this.listaPacientes.add(paciente);
      this.noPacientes++;
    }
  }

  // Método para ver los pacientes del enfermero
  public void verListaPacientes() {
    // Ordenamos alfabeticamente de manera descendente 'listaPacientes'
    listaPacientes.sort(Comparator.comparing(Paciente::getNombre).reversed());

    // Imprimimos
    System.out.println("Pacientes a cargo del enfermero " + nombre + ":");
    for (Paciente paciente : listaPacientes) {
      System.out.println(
        paciente.getNombre() + " (" + paciente.getEspecialidadAtencion() + ")."
      );
    }
  }

  // Método para dar tratamiento al paciente
  public void darTratamiento(Paciente paciente) {
    // Si el enfermero no tiene pacientes
    if (listaPacientes.isEmpty()) {
      System.out.println(
        "El enfermero " + nombre + " no tiene pacientes en su lista."
      );
      return;
    }

    // Si el paciente está en consulta (solo se pueden dar tratamientos después de una consulta)
    if (paciente.estaEnConsulta()) {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " se encuentra aún en consulta médica."
      );
      return;
    }

    // Si el enfermero tiene al paciente y no se le ha asignado tratamiento aún
    if (listaPacientes.contains(paciente) && !paciente.estaEnTratamiento()) {
      paciente.setEnTratamiento(true);
      System.out.println(
        "El enfermero " +
          nombre +
          " está ahora administrando el tratamiento del paciente " +
          paciente.getNombre() +
          "."
      );
      return;

      // Si el enfermero tiene al paciente pero ya se le asignó tratamiento
    } else if (listaPacientes.contains(paciente)) {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " ya se encuentra recibiendo tratamiento."
      );

      // Si el enfermero no tiene al paciente
    } else {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " no se encuentra en la lista del enfermero " +
          nombre +
          "."
      );
    }
  }
}
