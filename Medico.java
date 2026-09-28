import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Medico {

  private String nombre;
  private String cedula;
  private String especialidad;
  private int noPacientes;

  // Clave para checar si ya está ocupado y el paciente que está siendo consultado
  private Paciente pacienteSiendoConsultado;

  // Lista para llevar registro
  private List<Paciente> listaPacientes;

  // Constructor
  public Medico(String nombre, String cedula, String especialidad) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.especialidad = especialidad;
    this.noPacientes = 0;
    this.listaPacientes = new ArrayList<>();
    this.pacienteSiendoConsultado = null;
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

  // Get que retorna la cédula del médico
  public String getCedula() {
    return cedula;
  }

  // MÉTODOS

  // Método que registra todo el objeto Medico llamando al método 'registroMedico' del sistema con el objeto entero como argumento
  public void registroEnSistema(Sistema sistema) {
    sistema.registroMedico(this);
  }

  // Se agrega paciente a la lista de espera
  public void agregarPaciente(Paciente paciente) {
    if (this.noPacientes < 10) {
      this.listaPacientes.add(paciente);
      this.noPacientes++;
    }
  }

  // Método que imprime una solicitud por paciente
  public void solicitarPaciente() {
    System.out.println("Médico solicita un paciente.");
  }

  // Método que revisa si el médico puede dar consulta y de ser posible la da al primer Paciente en la lista de espera disponible
  public void darConsulta(Paciente paciente) {

    // Si no hay pacientes en 'listaPacientes'
    if (listaPacientes.isEmpty()) {
      System.out.println(
        "El Dr. " + nombre + " no tiene pacientes en su lista."
      );
      return;
    }

    // Si el médico está ocupado
    if (pacienteSiendoConsultado != null) {
      System.out.println(
        "El Dr. " +
          nombre +
          " se encuentra ocupado atendiendo al paciente " +
          pacienteSiendoConsultado.getNombre() +
          "."
      );
      return;
    }

    // Buscamos si el paciente está en la lista de pacientes
    if (
      listaPacientes.contains(paciente) &&
      !paciente.estaEnConsulta() &&
      !paciente.estaEnTratamiento()
    ) {
      paciente.setEnConsulta(true);
      pacienteSiendoConsultado = paciente;
      System.out.println(
        "El Dr. " + nombre + " está consultando a " + paciente.getNombre() + "."
      );
      return;

    // Si el médico tiene al paciente pero se encuentra en otra consulta o recibiendo tratamiento
    } else if (listaPacientes.contains(paciente)) {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " se ecnuentra en otra consulta o recibiendo tratamiento."
      );

    // Si el médico no tiene al paciente en su lista de pacientes
    } else {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " no se encuentra en la lista del Dr." +
          nombre +
          "."
      );
    }
  }

  // Método para dar tratamiento a un paciente después de una consulta
  public void darTratamiento(Paciente paciente) {
    // Si no hay pacientes en 'listaPacientes'
    if (listaPacientes.isEmpty()) {
      System.out.println(
        "El Dr. " + nombre + " no tiene pacientes en su lista."
      );
      return;
    }

    // Si el médico está ocupado
    if (
      pacienteSiendoConsultado != null &&
      !pacienteSiendoConsultado.equals(paciente)
    ) {
      System.out.println(
        "El Dr. " +
          nombre +
          " se encuentra ocupado atendiendo al paciente " +
          pacienteSiendoConsultado.getNombre() +
          "."
      );
      return;
    }

    // Buscamos si el paciente está en la lista de pacientes
    if (listaPacientes.contains(paciente) && !paciente.estaEnTratamiento()) {
      paciente.setEnConsulta(false);
      paciente.setEnTratamiento(true);
      if (paciente.equals(pacienteSiendoConsultado)) {
        pacienteSiendoConsultado = null;
      }
      System.out.println(
        "El Dr. " +
          nombre +
          " está dando tratamiento a " +
          paciente.getNombre() +
          "."
      );
      return;
    } else if (listaPacientes.contains(paciente)) {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " ya se encuentra recibiendo tratamiento."
      );
    } else {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " no se encuentra en la lista del Dr." +
          nombre +
          "."
      );
    }
  }

  // Imprimimos todos los pacientes en la lista de manera alfabética descendente
  public void verListaPacientes() {
    // Ordenamos alfabeticamente de manera descendente 'listaPacientes'
    listaPacientes.sort(Comparator.comparing(Paciente::getNombre).reversed());

    // Imprimimos
    System.out.println("Pacientes del Dr. " + this.nombre + ":");
    for (Paciente paciente : listaPacientes) {
      System.out.println(
        paciente.getNombre() + " (" + paciente.getEspecialidadAtencion() + ")."
      );
    }
  }
}
