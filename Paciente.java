public class Paciente {

  private String nombre;
  private String especialidadAtencion;

  private boolean enConsulta;
  private boolean enTratamiento;

  // Constructor
  public Paciente(
    String nombre,
    String especialidadAtencion
  ) {
    this.nombre = nombre;
    this.especialidadAtencion = especialidadAtencion;
    this.enConsulta = false;
    this.enTratamiento = false;
  }

  // GETTERS

  // Get que retorna el nombre
  public String getNombre() {
    return nombre;
  }

  // Get que retorna la especialidad de la atención que necesita
  public String getEspecialidadAtencion() {
    return especialidadAtencion;
  }

  // Retorna un bool indicando si el paciente está en consulta
  public boolean estaEnConsulta() {
    return enConsulta;
  }

  // Retorna un bool indicando si el paciente está recibiendo tratamiento
  public boolean estaEnTratamiento() {
    return enTratamiento;
  }

  // SETTERS

  public void setEnConsulta(boolean enConsulta) {
    this.enConsulta = enConsulta;
  }

  public void setEnTratamiento(boolean enTratamiento) {
    this.enTratamiento = enTratamiento;
  }

  // MÉTODOS

  // Método que registra todo el objeto Paciente llamando al método 'registroPaciente' del sistema con el objeto entero como argumento
  public void registroEnSistema(Sistema sistema) {
    sistema.registroPaciente(this);
  }

  // Método que imprime una solicitud por consulta
  public void solicitarConsulta() {
    System.out.println("Paciente solicita consulta.");
  }

  // Método que muestra un mensaje si el usuario está en tratamiento
  public void verTratamiento() {
    if (enTratamiento) {
      System.out.println("El paciente está en tratamiento.");
    }
  }

  // Método que muestra un mensaje si el usuario está en consulta
  public void verConsulta() {
    if (enConsulta) {
      System.out.println("El paciente está en consulta.");
    }
  }
}
