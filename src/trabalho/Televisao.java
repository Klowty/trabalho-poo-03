package trabalho;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Televisao {
    protected String id;
    protected int volume;
    protected Canal canalAtual;
    protected ArrayList<Canal> canaisCadastrados = new ArrayList<>();
    protected ArrayList<Canal> canaisDisponiveis = new ArrayList<>();
    protected ArrayList<Televisao> tvs;
    protected final int VOLUME_MAX = 10;
    protected final int VOLUME_MIN = 0;
    protected final Canal auxCanal = new Canal(8, "Record", false);
    Scanner teclado = new Scanner(System.in);
   


    public Televisao(ArrayList<Canal> c) {
        this.canaisDisponiveis = new ArrayList<>();
        for (int i = 0; i < c.size(); i++) {
            this.canaisDisponiveis.add(c.get(i));
        }
        this.volume = 5;
    }

    public Televisao(String id, int volume, Canal canalAtual) {
        this.id = id;
        this.volume = volume;
        this.canalAtual = canalAtual;
    }
    
     boolean verificadorTexto = false;
    
    public void alterarVolume(int aumentarOuDiminuir) {
        try {
            if (aumentarOuDiminuir == 1) {
                if (volume == 10)
                    throw new ImpedirAlteracaoVolumeException();
                else
                    this.volume++;
            }
        } catch (ImpedirAlteracaoVolumeException t) {
                           if (verificadorTexto == false) {
                  t.printStackTrace();
                  verificadorTexto = true;
            }
        }
        try {
            if (aumentarOuDiminuir == 2) {
                if (volume == 0) {
                    throw new ImpedirAlteracaoVolumeException();
                } else {
                    this.volume--;
                }
            }
        } catch (ImpedirAlteracaoVolumeException t) {
               if (verificadorTexto == false) {
                  t.printStackTrace();
                  verificadorTexto = true;
            }
            
        }
        if (aumentarOuDiminuir != 1 && aumentarOuDiminuir != 2 && verificadorTexto == false) {
            System.out.println("Digite uma das opções!");
            verificadorTexto = true;
        }
        
        if (verificadorTexto == false) {
            System.out.println("Volume atual: "+this.volume);
        }

    }

    public abstract void cadastrarCanais();

    public Boolean verificarCanalExistente(Canal channel) {
        boolean status = false;
        for (int i = 0; i < canaisDisponiveis.size(); i++) {
            if (canaisDisponiveis.get(i) == channel) {
                if (verificadorTexto == false) {
                    System.out.println("O canal existe uhul");
                    verificadorTexto = true;
            }   
                status = true;
            } else {
                status = false;
            }
        }
        return status;
    }

    public void sintonizar(int canal) {
        boolean verificar = false;
        try {
            for (int i = 0; i < canaisDisponiveis.size(); i++) {
                if (canaisDisponiveis.get(i).getNumero() == canal) {
                    this.canalAtual = new Canal();
                    this.canalAtual = canaisDisponiveis.get(i);
                    
                    if (verificadorTexto == false) {
                        System.out.println("Canal sintonizado!");
                        verificadorTexto = true;
            }  
                    
                    verificar = true;
                }
            }
            if (verificar == false) {
                throw new CanalInexistenteException();
            }
        } catch (CanalInexistenteException e) {
            if (verificadorTexto == false) {
                e.printStackTrace();
                verificadorTexto = true;
            }    
        }
    }

    public void alterarCanal(String acao) {
        if (acao.equalsIgnoreCase("próximo") || acao.equalsIgnoreCase("proximo")) {
            for (int i = 0; i < canaisDisponiveis.size(); i++) {
                if (canaisDisponiveis.get(i) == this.canalAtual) {
                    if (i == canaisDisponiveis.size() - 1) {
                        this.canalAtual = canaisDisponiveis.get(0);
                        
                        if (verificadorTexto == false) {
                            System.out.println("Canal atual: "+this.getCanalAtual().getNome()+" - "+this.getCanalAtual().getNumero());
                            verificadorTexto = true;
                        }
                        
                        break;
                    } else {
                        this.canalAtual = canaisDisponiveis.get(i + 1);
                        
                        if (verificadorTexto == false) {
                            System.out.println("Canal atual: "+this.getCanalAtual().getNome()+" - "+this.getCanalAtual().getNumero());
                            verificadorTexto = true;
                        }
                        
                        break;
                    }
                }
            }
        } else if (acao.equalsIgnoreCase("anterior")) {
            for (int i = 0; i < canaisDisponiveis.size(); i++) {
                if (canaisDisponiveis.get(i) == this.canalAtual) {
                    if (i == canaisDisponiveis.size() - 1) {
                        this.canalAtual = canaisDisponiveis.get(canaisDisponiveis.size() - 1);
                        
                        if (verificadorTexto == false) {
                            System.out.println("Canal atual: "+this.getCanalAtual().getNome()+" - "+this.getCanalAtual().getNumero());
                            verificadorTexto = true;
                        }
                        
                        break;
                    } else {
                        this.canalAtual = canaisDisponiveis.get(i - 1);
                         
                        if (verificadorTexto == false) {
                            System.out.println("Canal atual: "+this.getCanalAtual().getNome()+" - "+this.getCanalAtual().getNumero());
                            verificadorTexto = true;
                        }
                        
                        break;
                    }
                }
            }
        }
    }


    public void informarDados() {
                         
        if (verificadorTexto == false) {
            System.out.println("Nome: " + canalAtual.getNome());
            System.out.println("Numero: " + canalAtual.getNumero());
            System.out.println("HD? " + canalAtual.getHd());
            System.out.println("Volume: " + getVolume());
            verificadorTexto = true;
        }
    }

    public void organizarDados() {
        int aux, auxint = 0;
        String auxstring;
        boolean auxHD;
        while (auxint <= canaisDisponiveis.size()) {
            for (int i = 0; i < canaisDisponiveis.size() - 1; i++) {

                if (canaisDisponiveis.get(i).getNumero() > canaisDisponiveis.get(i + 1).getNumero()) {
                    aux = canaisDisponiveis.get(i + 1).getNumero();
                    auxstring = canaisDisponiveis.get(i + 1).getNome();
                    auxHD = canaisDisponiveis.get(i + 1).getHd();
                    canaisDisponiveis.get(i + 1).setNumero(canaisDisponiveis.get(i).getNumero());
                    canaisDisponiveis.get(i + 1).setNome(canaisDisponiveis.get(i).getNome());
                    canaisDisponiveis.get(i + 1).setHd(canaisDisponiveis.get(i).getHd());
                    canaisDisponiveis.get(i).setNumero(aux);
                    canaisDisponiveis.get(i).setNome(auxstring);
                    canaisDisponiveis.get(i).setHd(auxHD);
                }
                aux = 0;

            }
            auxint++;
        }
        if (verificadorTexto == false) {
        for (int i = 0; i < canaisDisponiveis.size(); i++) {
            System.out.println("-------------");
            System.out.print("Nome - "+canaisDisponiveis.get(i).getNome()+" | ");
            System.out.print("Numero - "+canaisDisponiveis.get(i).getNumero()+" | ");
            System.out.print("HD - "+canaisDisponiveis.get(i).getHd()+" | \n");
            System.out.println("-------------");
        }
     }
    }
    public ArrayList<Televisao> getTvs() {
        return tvs;
    }

    public void setTvs(ArrayList<Televisao> tvs) {
        this.tvs = tvs;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }

    public ArrayList<Canal> getCanaisDisponiveis() {
        return canaisDisponiveis;
    }

    public void setCanaisDisponiveis(ArrayList<Canal> canaisDisponiveis) {
        this.canaisDisponiveis = canaisDisponiveis;
    }

    public ArrayList<Canal> getCanaisCadastrados() {
        return canaisCadastrados;
    }

    public void setCanaisCadastrados(ArrayList<Canal> canaisCadastrados) {
        this.canaisCadastrados = canaisCadastrados;
    }
}