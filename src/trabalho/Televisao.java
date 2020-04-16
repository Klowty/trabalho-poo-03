package trabalho;

import java.util.ArrayList;

public abstract class Televisao {
    private String id;
    private int volume;
    private Canal canalAtual;
    private ArrayList<Canal> canaisCadastrados;
    private ArrayList<Canal> canaisDisponiveis;
    private final int VOLUME_MAX = 10;
    private final int VOLUME_MIN = 0;
    
    public void Tevelisao(Canal c){
        this.canaisDisponiveis = new ArrayList<>();
        this.canaisDisponiveis.add(c);
        this.volume = 5;
    }
    
    public void alterarVolume(int aumentarOuDiminuir){
        if(aumentarOuDiminuir == 1){
            this.volume++;
        }else if(aumentarOuDiminuir == 2){
            this.volume--;
        }else{
            System.out.println("Digite uma das opções!");
        }
    }
    
    public abstract void cadCanais();
    
    public Boolean verificarCanalExistente(Canal channel, Boolean status){
        for (int i = 0; i < canaisDisponiveis.size(); i++) {
            if (canaisDisponiveis.get(i) == channel) {
                System.out.println("O canal existe uhul");
                status = true;
            }else{
            status = false;
            }
        }
        return status;
    }
    
    public void sintonizar(int canal){
        for (int i = 0; i < canaisDisponiveis.size(); i++) {
            
            try{
            if (canaisDisponiveis.get(i).getNumero() == canal) {
                this.canalAtual = new Canal();
                this.canalAtual = canaisDisponiveis.get(i);
            }
                        
            }catch(Exception e){
                 System.out.println("O canal não existe");
            }
        }
    }
    
    public void alterarCanal(String acao){
        if(acao.equalsIgnoreCase("próximo") || acao.equalsIgnoreCase("proximo")){
        for(int i = 0; i < canaisDisponiveis.size(); i++){
            if (canaisDisponiveis.get(i) == this.canalAtual) {
                if (i == canaisDisponiveis.size() - 1) {
                    this.canalAtual = canaisDisponiveis.get(0);
                }else{
                this.canalAtual = canaisDisponiveis.get(i+1);
                }
            }
        }
        }else if(acao.equalsIgnoreCase("anterior")){
            for(int i = 0; i < canaisDisponiveis.size(); i++){
                if (canaisDisponiveis.get(i) == this.canalAtual) {
                    if (i == canaisDisponiveis.size() - 1) {
                        this.canalAtual = canaisDisponiveis.get(canaisDisponiveis.size() - 1);
                    }else{
                    this.canalAtual = canaisDisponiveis.get(i-1);
                }
            }
        }
      }
    }

    
    public void informarDados() {
        System.out.println("Nome: "+canalAtual.getNome());
        System.out.println("Numero: "+canalAtual.getNumero());
        System.out.println("HD? "+canalAtual.getHd());
    }
    
    
}
