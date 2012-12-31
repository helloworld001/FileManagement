
public class FileMessage{
	private int size=0;
	private String name="";
	private String text="";
	private boolean isSaved= false;
	public FileMessage() {
		// TODO Auto-generated constructor stub	
		this.text="adklfjaklfjsdlakf";
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name =  name;
	}
	public int getSize(){
		return this.size;
	}
	public String getText(){
		return this.text;
	}
	public void setText(String text){
		this.text=text;
	}
	public boolean Saved(){
		return isSaved;
	}
	public void setSaved(boolean save){
		this.isSaved = save;
	}
	@Override
	public String toString(){
		return name;
	}
}
