package lib;

import java.util.ArrayList;

public class Grafo<T> {

    private ArrayList<Aresta> arestas;
    private ArrayList<Vertice<T>> vertices;


    public Grafo(ArrayList<Aresta> arestas, ArrayList<Vertice<T>> vertices) {
        this.arestas = arestas;
        this.vertices = vertices;
    }

    public Vertice adicionarVertice(T valor){
        Vertice<T> novo = new Vertice<T>(valor);
        this.vertices.add(novo);
        return novo;
    }

    public Vertice obterVertice(T valor){
        Vertice v;
        for(int i=0;i<this.vertices.size();i++){
            v=this.vertices.get(i);
            if(v.getValor().equals(valor)){
                return v;
            }
        }
        //se chegou aqui é porque não existe um vértice com esse valor
        return null;
    }

    public void adicionarAresta(T origem, T destino, float peso){
        Vertice verticeOrigem, verticeDestino;
        Aresta novAresta;
        //busco o vértice com o valor de origem
        verticeOrigem = obterVertice(origem);
        //se ainda não existe vertice com o valor da origem, vou criar o vértice
        if(verticeOrigem == null){
            verticeOrigem = adicionarVertice(origem);
        }
        //busco o vértice com o valor de destino
        verticeDestino = obterVertice(destino);
        //se ainda não existe vertice com o valor de destino, vou criar o vértice
        if(verticeDestino == null){
            verticeDestino = adicionarVertice(destino);
        }
        //agora crio a aresta que vai da o rigem ao destino
        novAresta = new Aresta(verticeOrigem, verticeDestino, peso);
        //adiciono a aresta à lista do grafo
        this.arestas.add(novAresta);
    }

    public void buscaEmLargura(){
        ArrayList<Vertice> marcados = new ArrayList<Vertice>();
        ArrayList<Vertice> fila = new ArrayList<Vertice>();
        Vertice atual = this.vertices.get(0);
        fila.add(atual);
        while (fila.size()>0){
            atual = fila.get(0);
            fila.remove(0);
            marcados.add(atual);
            System.out.println(atual.getValor());
            ArrayList<Aresta> destinos = this.obterDestinos(atual);
            Vertice proximo;
            for(int i=0; i<destinos.size(); i++){
                proximo = destinos.get(i).getDestino();
                if(!marcados.contains(proximo) && !fila.contains(proximo)){
                    fila.add(proximo);
                }
            }

        }
    }

    private ArrayList<Aresta> obterDestinos(Vertice v){
        ArrayList<Aresta> destinos = new ArrayList<Aresta>();
        Aresta atual;
        for(int i=0; i<this.arestas.size(); i++){
            atual = this.arestas.get(i);
            if(atual.getOrigem().equals(v)){
                destinos.add(atual);
            }
        }
        return destinos;
    }



}
