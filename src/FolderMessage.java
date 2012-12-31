
public class FolderMessage {
	private int size=0;
	private String name="";
	public FolderMessage(String name) {
		// TODO Auto-generated constructor stub	
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public int getSize(){
		return this.size;
	}
	@Override
	public String toString(){
		return name;
	}
	
}
