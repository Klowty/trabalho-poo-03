package trabalho;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Canal c1 = new Canal();
        Canal c2 = new Canal();
        Canal c3 = new Canal();
        Canal c4 = new Canal();
        Canal c5 = new Canal();
        ArrayList<Canal> canais = new ArrayList<>();
        c1.setNumero(10);
        c1.setNome("Globo");
        c1.setHd(true);

        c2.setNumero(8);
        c2.setNome("Record");
        c2.setHd(false);

        c3.setNumero(12);
        c3.setNome("SBT");
        c3.setHd(false);

        c4.setNumero(13);
        c4.setNome("Band");
        c4.setHd(true);

        c5.setNumero(22);
        c5.setNome("Rede TV");
        c5.setHd(false);

        canais.add(c1);
        canais.add(c2);
        canais.add(c3);
        canais.add(c4);
        canais.add(c5);

        SmartTV t1 = new SmartTV(canais, 40);
        TVHD t2 = new TVHD(canais, "LED");
        
        
        t1.cadastrarCanais();
        t2.cadastrarCanais();
//        t1.sintonizar(10);
       t1.organizarDados();
       t2.organizarDados();
        
        ArrayList<Televisao> tvs = new ArrayList<>();
        tvs.add(t1);
        tvs.add(t2);
        
        ControleRemoto cr = new ControleRemoto(tvs);
                
        System.out.println("+---- Televisão ----+");
        System.out.println("*** Por padrão, duas TV's já foram criadas, uma de cada tipo :) ***");
        System.out.println("Tambem foram criados os seginte canais: ");
        System.out.println(c1.getNome()+" - "+c1.getNumero());
        System.out.println(c2.getNome()+" - "+c2.getNumero());
        System.out.println(c3.getNome()+" - "+c3.getNumero());
        System.out.println(c4.getNome()+" - "+c4.getNumero());
        System.out.println(c5.getNome()+" - "+c5.getNumero());
        System.out.println("Seu controle remoto também já foi criado e está pronto para uso");
        System.out.println("+-------------------------------------+\n");
        
        int n = 0;
        do {
            System.out.println("O que quer fazer?");
            System.out.println("1- Criar nova TV");
            System.out.println("2- Aumentar volume");
            System.out.println("3- Diminuir volume");
            System.out.println("4- Sintonizar em um canal");
            System.out.println("5- Próximo canal");
            System.out.println("6- Canal Anterior");
            System.out.println("7- Informar dados");
            System.out.println("8- Mostrar grade");
            System.out.println("9- Sair");
            n = teclado.nextInt();
            switch(n){
                case 1:
                    System.out.println("A tv possui identificação? (digite 'sim' ou 'não)");
                    String escolha = teclado.next();
                    String ident = "Sem";
                    if (escolha.equals("sim")) {
                        System.out.println("Digite a identificação");
                         ident = teclado.next();
                    }
                    System.out.println("Digite o tipo da TV (SmartTV ou TVHD): ");
                    String tipo = teclado.next();
                    if (tipo.equals("SmartTV")) {
                        System.out.println("Possui quantas polegadas?");
                        int polegadas = teclado.nextInt();
                        
                        SmartTV novaSMTV = new SmartTV(canais, polegadas);
                        novaSMTV.setId(ident);
                        
                        novaSMTV.cadastrarCanais();
                        novaSMTV.organizarDados();
                        
                        tvs.add(novaSMTV);
                        cr.addTV(novaSMTV);
                        
                        System.out.println("+------ TV CRIADA COM SUCESSO! ------+\n");
                    }else if(tipo.equals("TVHD")){
                        System.out.println("Digite o modelo de TV (LED, Plasma, HD)");
                        String modelo = teclado.next();
                        
                        TVHD novaTVHD = new TVHD(canais, modelo);
                        novaTVHD.setId(ident);
                        
                        novaTVHD.cadastrarCanais();
                        novaTVHD.organizarDados();
                        
                        tvs.add(novaTVHD);
                        cr.addTV(novaTVHD);
                        System.out.println("+------ TV CRIADA COM SUCESSO! ------+\n");
                    }else{
                        System.out.println("Preencha os campos corretamente!\n");
                    }
                  
                    break;
                    
                case 2:
                    cr.alterarVolume(1);
                    break;
                    
                case 3:
                    cr.alterarVolume(2);
                    break;
                    
                case 4:
                    System.out.println("Digite o canal");
                    int canalEscolhido = teclado.nextInt();
                    cr.sintonizarCanal(canalEscolhido);
                    break;
                    
                case 5:
                    cr.alterarCanal("proximo");
                    break;
                    
                case 6:
                    cr.alterarCanal("anterior");
                    break;
                
                case 7:
                    cr.informarDados();
                    break;
                    
                case 8:
                    cr.mostrarGrade();
                    break;
            }
        } while (n != 9);
        
        
    }
}