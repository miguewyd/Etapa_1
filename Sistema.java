// Importes
import java.util.ArrayList;
import java.util.List;

public class Sistema {

  private String nombreHospital;
  private int noMedicos;
  private int noEnfermeros;
  private int noPacientes;

  // Listas para llevar registro
  private List<Medico> medicos;
  private List<Enfermero> enfermeros;
  private List<Paciente> pacientes;

  // Constructor
  public Sistema(String nombreHospital) {
    this.nombreHospital = nombreHospital;
    this.noMedicos = 0;
    this.noEnfermeros = 0;
    this.noPacientes = 0;
    this.medicos = new ArrayList<>();
    this.enfermeros = new ArrayList<>();
    this.pacientes = new ArrayList<>();
  }

  // GETTERS

  // Get que retorna el nombre del hospital
  public String getNombreHospital() {
    return nombreHospital;
  }

  // Get que retorna el número de médicos
  public int getNoMedicos() {
    return noMedicos;
  }

  // Get que retorna el número de enfermeros
  public int getNoEnfermeros() {
    return noEnfermeros;
  }

  // Get que retorna el número de pacientes
  public int getNoPacientes() {
    return noPacientes;
  }

  // Get que retorna la lista de médicos
  public List<Medico> getMedicos() {
    return medicos;
  }

  // Get que retorna la lista de enfermeros
  public List<Enfermero> getEnfermeros() {
    return enfermeros;
  }

  // Get que retorna la lista de pacientes
  public List<Paciente> getPacientes() {
    return pacientes;
  }

  // MÉTODOS

  // Método que agrega objeto Médico a la lista de los médicos y suma uno al número de médicos
  public void registroMedico(Medico medico) {
    this.medicos.add(medico);
    this.noMedicos++;
  }

  // Método que agrega objeto Enfermero a la lista de los enfermeros y suma uno al número de enfermeros
  public void registroEnfermero(Enfermero enfermero) {
    this.enfermeros.add(enfermero);
    this.noEnfermeros++;
  }

  // Método que agrega objeto Paciente a la lista de los pacientes y suma uno al número de pacientes
  public void registroPaciente(Paciente paciente) {
    this.pacientes.add(paciente);
    this.noPacientes++;
  }

  // Método asignarPaciente a un Médico
  public void asignarPaciente(Paciente paciente, Medico medico) {
    // Solo asignamos paciente si la especialidad del médico coincide con la requerida y si el médico no tiene todavía 10 o más pacientes
    if (
      paciente.getEspecialidadAtencion().equals(medico.getEspecialidad()) &&
      medico.getNoPacientes() < 10
    ) {
      medico.agregarPaciente(paciente);
      System.out.println("Paciente asignado al médico de manera exitosa.");
    } else {
      System.out.println(
        "Error: No coincide la especialidad o el médico alcanzó su límite de 10 pacientes."
      );
    }
  }

  // Método asignarPaciente a un Enfermero
  public void asignarPaciente(Paciente paciente, Enfermero enfermero) {
    // Solo asignamos paciente si la especialidad del enfermero coincide con la requerida y si el médico no tiene todavía 3 o más pacientes
    if (
      paciente.getEspecialidadAtencion().equals(enfermero.getEspecialidad()) &&
      enfermero.getNoPacientes() < 3
    ) {
      enfermero.agregarPaciente(paciente);
      System.out.println("Paciente asignado al enfermero de manera exitosa.");
    } else {
      System.out.println(
        "Error: No coincide la especialidad o el enfermero alcanzó su límite de 3 pacientes."
      );
    }
  }
}
