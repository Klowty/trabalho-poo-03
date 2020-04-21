package trabalho;

import java.util.ArrayList;

public class TVHD extends Televisao{
    private String modelo;

    public TVHD(ArrayList<Canal> c, String modelo){
        super(c);
        this.modelo = modelo;
    }

    public TVHD(String id, int volume, Canal canalAtual, String modelo){
        super(id, volume, canalAtual);
        this.modelo = modelo;
    }

    @Override
    public void cadastrarCanais(){
        int j = 0;
        for (int i = 0; i < this.canaisDisponiveis.size(); i++) {
            if (this.canaisDisponiveis.get(i).getHd() == true) {
                this.canaisCadastrados.add(this.canaisDisponiveis.get(i));
                j++;
            }
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}