package trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleRemoto {

    private ArrayList<Televisao> CR = new ArrayList<>();
    Scanner teclado = new Scanner(System.in);

    public ControleRemoto(ArrayList<Televisao> cr) {
        this.CR = cr;
    }

    public void addTV(Televisao t1) {
        CR.add(t1);
    }

    public void alterarVolume(int aumentarOuDiminuir) {
        for (int i = 0; i < CR.size(); i++) {
            CR.get(i).alterarVolume(aumentarOuDiminuir);
            controleTexto();
        }
        zerarTexto();
    }

    public void sintonizarCanal(int canal) {
        for (int i = 0; i < CR.size(); i++) {
            CR.get(i).sintonizar(canal);
            controleTexto();
        }
        zerarTexto();
    }

    public void alterarCanal(String acao) {
        for (int i = 0; i < CR.size(); i++) {
            CR.get(i).alterarCanal(acao);
            controleTexto();
        }
        zerarTexto();
    }

    public void informarDados() {
        for (int i = 0; i < CR.size(); i++) {
            CR.get(i).informarDados();
            controleTexto();
        }
        zerarTexto();
    }

    public void mostrarGrade() {
        for (int i = 0; i < CR.size(); i++) {
            CR.get(i).organizarDados();
            controleTexto();
        }
        zerarTexto();      
    }

    public void controleTexto(){
            for (int i = 0; i < CR.size(); i++) {
            CR.get(i).verificadorTexto = true;
        }
    }
    
    public void zerarTexto(){
            for (int i = 0; i < CR.size(); i++) {
            CR.get(i).verificadorTexto = false;
        }
    }
}