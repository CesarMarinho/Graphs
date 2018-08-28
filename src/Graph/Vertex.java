package Graph;


public class Vertex {
	
	private String vertexName;
	private int vertexId;
	
	public Vertex(String vertexName, int vertexId){
		this.vertexName = vertexName;
		this.vertexId = vertexId;
	}
	
	public Vertex(int vertexId){
		this.vertexId = vertexId;
	}

	public String getVertexName() {
		return vertexName;
	}

	public void setVertexName(String vertexName) {
		this.vertexName = vertexName;
	}

	public int getVertexId() {
		return vertexId;
	}

	public void setVertexId(int vertexId) {
		this.vertexId = vertexId;
	}
	
	

}
