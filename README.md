# DiaDiaGame

**Materia**: Programmazione Orientata agli Oggetti (Università Roma Tre)

**Autore**: Marco

---

## 1. Descrizione del Progetto

`DiaDiaGame` è un gioco testuale in Java sviluppato come progetto per la materia di Programmazione Orientata agli Oggetti. L’obiettivo è esplorare un labirinto di stanze, raccogliere oggetti e interagire con l’ambiente per raggiungere l’uscita finale. Il progetto mette in pratica i concetti fondamentali di OOP: incapsulamento, ereditarietà, polimorfismo, interfacce e gestione delle eccezioni.

### Obiettivi didattici passo-passo

1. **Modellazione del dominio**: definire classi per la logica di gioco, i comandi e il giocatore.
2. **Organizzazione in package**: separare il codice in ambienti, command e giocatore.
3. **Ereditarietà e interfacce**: implementare comandi tramite classi astratte e interfacce per l’I/O.
4. **Flusso di gioco**: leggere input (console o simulato) e aggiornare lo stato della `Partita`.
5. **Test unitari**: verificare comportamenti chiave con JUnit.

---

## 2. Struttura delle Cartelle

```
DiaDiaGame_java_ProgrammazioneOrientataAgliOggetti-main/
├── src/                  # Sorgenti principali
│   ├── module-info.java  # Definizione del modulo Java
│   └── it/uniroma3/diadia/
│       ├── DiaDia.java                   # Classe principale (entry point)
│       ├── IO.java                       # Interfaccia I/O generica
│       ├── IOConsole.java                # I/O da console
│       ├── IOSimulator.java              # I/O simulato (per testing)
│       ├── Partita.java                  # Stato e logica della partita
│       ├── ambienti/
│       │   └── Labirinto.java            # Creazione e collegamento delle stanze
│       ├── command/
│       │   ├── ComandoAiuto.java
│       │   ├── ComandoFine.java
│       │   ├── ComandoGuarda.java
│       │   ├── ComandoNonValido.java
│       │   ├── ComandoPosa.java
│       │   ├── ComandoPrendi.java
│       │   ├── ComandoVai.java
│       │   └── FabbricaDiComandi*.java   # Factory per i comandi
│       └── giocatore/
│           ├── Borsa.java                # Inventario del giocatore
│           └── Giocatore.java            # Stato e azioni del giocatore
├── test/                # Test unitari (JUnit)
└── README.md            # Questo file
```

---

## 3. Prerequisiti

* Java Development Kit (JDK) 1.7
* Eclipse IDE
* Git (per il versionamento)

---

## 4. Installazione e Configurazione

1. **Clona il repository**:

   ```bash
   git clone https://github.com/tuo-utente/DiaDiaGame_java_ProgrammazioneOrientataAgliOggetti-main.git
   cd DiaDiaGame_java_ProgrammazioneOrientataAgliOggetti-main
   ```
2. **Importa il progetto in Eclipse**:

   * `File > Import > Existing Projects into Workspace` e seleziona la cartella del progetto.
3. **(Nessuna estrazione aggiuntiva necessaria)**

---

## 5. Compilazione e Esecuzione

### Da linea di comando

```bash
# Compilazione
javac -d bin -sourcepath src src/it/uniroma3/diadia/DiaDia.java

# Esecuzione
java -cp bin it.uniroma3.diadia.DiaDia
```

### Dall’IDE (Eclipse)

* Clic destro su `DiaDia.java` → `Run As > Java Application`.
* Assicurati che la **working directory** sia la cartella principale del progetto.

---

## 6. Test Unitari

I test JUnit si trovano nella cartella `test/`. Per eseguirli:

* **Da Eclipse**: click destro su `test/` → `Run As > JUnit Test`.

---

## 7. Panoramica delle Classi

* **DiaDia**: entry point e ciclo principale di gioco.
* **IO, IOConsole, IOSimulator**: astrazione dell’input/output.
* **Partita**: modello dello stato di gioco (stanze, inventario, stato finale).
* **Labirinto**: definizione della mappa e collegamento delle stanze.
* **Comando**\*: gerarchia dei comandi utente (`vai`, `prendi`, `posa`, ecc.).
* **FabbricaDiComandi**: parser e factory per i comandi.
* **Giocatore, Borsa**: dati e operazioni del giocatore.

---

## 8. Esempio di Utilizzo

```plaintext
Benvenuto in DiaDia! Digita 'aiuto' per vedere i comandi disponibili.
> vai nord
Ti trovi in un corridoio buio.
> prendi lampada
Hai raccolto: lampada
> vai est
Hai vinto! Complimenti!
```

---

##
