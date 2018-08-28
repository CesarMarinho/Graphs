package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListGraph {
	
	private int numberOfVertices;
	private ArrayList<Integer>[] adjacencies; //list with the index vertices
	
	public ListGraph(int numberOfVertices){
		this.numberOfVertices = numberOfVertices;
		fillList();
	}
	
	public ListGraph(String path){
		readArchive(path);
	}

	public void addArch(Vertex A, Vertex B){ //Add an arch from A to B
		ArrayList<Integer> aux = new ArrayList<Integer>();
		if(!adjacencies[A.getVertexId()].isEmpty()){
			aux = adjacencies[A.getVertexId()];
		}
		aux.add(B.getVertexId());
		adjacencies[A.getVertexId()] = aux;
	}
	
	public ArrayList<Integer> getSuccessors(Vertex A){
		return adjacencies[A.getVertexId()];
	}
	
	public boolean existsArch(Vertex A, Vertex B){
		for(Integer i:adjacencies[A.getVertexId()]){
			if(i == B.getVertexId()) return true;
		}
		return false;
	}
	
	public void readArchive(String path){
		try {
			FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); 
			this.numberOfVertices = Integer.parseInt(linha);
			this.adjacencies = new ArrayList[numberOfVertices];
			fillList();
					
			String fragmented[];
			Vertex v;
			int count = 0;		      		      

			while (linha != null) {	

				linha = lerArq.readLine();
				if(linha == null) break;	

				fragmented = linha.split(" ");

				v = new Vertex(fragmented[0],count);			    	  

				for(int i=1;i<fragmented.length;i++){
					addArch(v, new Vertex(Integer.parseInt(fragmented[i])));					
				}				
				count++;

			}		 
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}	
	}
	
	public void print(){		
		for(int i=0;i<this.adjacencies.length;i++){
			System.out.print(i +" : ");			
			for(Integer j:adjacencies[i]){
				System.out.print(j + ", ");
			}
			System.out.println("");
		}
	}
	
	//auxiliary functions
	private void fillList(){
		this.adjacencies = new ArrayList[numberOfVertices];
		for(int i=0;i<numberOfVertices;i++){
			ArrayList<Integer> aux = new ArrayList<Integer>();
			adjacencies[i] = aux;
		}		
	}
}
