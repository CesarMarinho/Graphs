package Graph;

public class Graph {
	
	private MatrixGraph matrixGraph;
	private ListGraph listGraph;
	
	public Graph(String type, String path){
		if(type.toLowerCase().equals("matrix")){
			
			matrixGraph = new MatrixGraph(path);
			
		}else if(type.toLowerCase().equals("list")){
			
			listGraph = new ListGraph(path);
			
		}
	}
	
	public Graph(String type, int numberOfVertices){
		if(type.toLowerCase().equals("matrix")){

			matrixGraph = new MatrixGraph(numberOfVertices);

		}else if(type.toLowerCase().equals("list")){

			listGraph = new ListGraph(numberOfVertices);

		}
	}
	
	public void print(){
		if(matrixGraph != null){
			this.matrixGraph.print();
		}else{			
			this.listGraph.print();
		}
	}

}
