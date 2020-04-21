package trabalho;

import java.util.ArrayList;

public class SmartTV extends Televisao {
    private int polegadas;

    public SmartTV(ArrayList<Canal> c, int polegadas){
        super(c);
        this.polegadas = polegadas;
    }

    public SmartTV(String id, int volume, Canal canalAtual, int polegadas){
        super(id, volume, canalAtual);
        this.polegadas = polegadas;
    }


    @Override
    public void cadastrarCanais(){
        this.canaisCadastrados = this.canaisDisponiveis;
        this.canalAtual = this.canaisCadastrados.get(0);
    }
}   