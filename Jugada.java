// Clase abstracta que define la interfaz común para todas las jugadas posibles
public abstract class Jugada {
  // Método abstracto que recibe una jugada como parámetro y devuelve un resultado como cadena
  public abstract String jugar(Jugada jugada);
}

// Clase concreta que implementa la jugada de piedra
public class Piedra extends Jugada {
  // Método que define el algoritmo para jugar con piedra
  @Override
  public String jugar(Jugada jugada) {
    // Comparar la jugada recibida y devolver el resultado según las reglas del juego
    if (jugada instanceof Piedra) {
      return "Empate";
    } else if (jugada instanceof Papel) {
      return "Pierde";
    } else if (jugada instanceof Tijera) {
      return "Gana";
    } else {
      return "Jugada inválida";
    }
  }
}

// Clase concreta que implementa la jugada de papel
public class Papel extends Jugada {
  // Método que define el algoritmo para jugar con papel
  @Override
  public String jugar(Jugada jugada) {
    // Comparar la jugada recibida y devolver el resultado según las reglas del juego
    if (jugada instanceof Piedra) {
      return "Gana";
    } else if (jugada instanceof Papel) {
      return "Empate";
    } else if (jugada instanceof Tijera) {
      return "Pierde";
    } else {
      return "Jugada inválida";
    }
  }
}

// Clase concreta que implementa la jugada de tijera
public class Tijera extends Jugada {
  // Método que define el algoritmo para jugar con tijera
  @Override
  public String jugar(Jugada jugada) {
    // Comparar la jugada recibida y devolver el resultado según las reglas del juego
    if (jugada instanceof Piedra) {
      return "Pierde";
    } else if (jugada instanceof Papel) {
      return "Gana";
    } else if (jugada instanceof Tijera) {
      return "Empate";
    } else {
      return "Jugada inválida";
    }
  }
}

// Clase que representa el juego entre dos jugadores
public class Juego {
  // Referencia a una jugada abstracta
  private Jugada jugada;
  
  // Método que recibe una cadena como parámetro y asigna la jugada correspondiente a la referencia
  public void elegirJugada(String opcion) {
    // Asignar la jugada según la opción elegida
    switch (opcion) {
      case "piedra":
        jugada = new Piedra();
        break;
      case "papel":
        jugada = new Papel();
        break;
      case "tijera":
        jugada = new Tijera();
        break;
      default:
        jugada = null;
        break;
    }
  }
  
  // Método que recibe una jugada como parámetro y delega la ejecución de la jugada en la referencia
  public String jugar(Jugada jugada) {
    // Verificar que la referencia no sea nula
    if (this.jugada != null) {
      // Invocar el método jugar de la referencia y devolver el resultado
      return this.jugada.jugar(jugada);
    } else {
      // Devolver un mensaje de error
      return "No se ha elegido una jugada válida";
    }
  }
  
  // Método principal para probar el ejemplo
  public static void main(String[] args) {
    // Crear un objeto de juego
    Juego juego = new Juego();
    
    // Elegir una jugada para el jugador 1
    juego.elegirJugada("piedra");
    
    // Crear una jugada para el jugador 2
    Jugada jugada = new Tijera();
    
    // Ejecutar el juego y mostrar el resultado
    System.out.println(juego.jugar(jugada));
  }
}
