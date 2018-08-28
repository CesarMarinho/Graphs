package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MatrixGraph {
	
	private int numberOfVertices;
	private int[][] adjacencies; //adjacencies matrix
	
	public MatrixGraph(int numberOfVertices){
		this.numberOfVertices = numberOfVertices;
		adjacencies = new int[numberOfVertices][numberOfVertices];
		fillMatrix();
	}
	
	public MatrixGraph(String path){
		readArchive(path);
	}
	
	public void addArch(Vertex A, Vertex B){ //Add an arch from A to B
		adjacencies[A.getVertexId()][B.getVertexId()] += 1;
	}
	
	public ArrayList<Integer> getSuccessors(Vertex A){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for(int i = 0;i<this.numberOfVertices;i++){
			if(adjacencies[A.getVertexId()][i] > 0){
				aux.add(adjacencies[A.getVertexId()][i]);
			}			
		}
		return aux;
	}
	
	public boolean existsArch(Vertex A, Vertex B){
		if(adjacencies[A.getVertexId()][B.getVertexId()] > 0){
			return true;
		}
		return false;
	}
	
	public void readArchive(String path){
		
		try {
		      FileReader arq = new FileReader(path);
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine(); 
		      this.numberOfVertices = Integer.parseInt(linha);
		      this.adjacencies = new int[this.numberOfVertices][this.numberOfVertices];
		      fillMatrix();
		      
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
		for(int i=0;i<adjacencies.length;i++){
			for(int j=0;j<adjacencies.length;j++){
				System.out.print(adjacencies[i][j]+" | ");
			}
			System.out.println("");
		}
	}
	
	//auxiliary functions
	private void fillMatrix(){ //fill the matrix with 0
		for(int i=0;i<numberOfVertices;i++){
			for(int j=0;j<numberOfVertices;j++){
				adjacencies[i][j] = 0;
			}
		}
	}
	
	

}
