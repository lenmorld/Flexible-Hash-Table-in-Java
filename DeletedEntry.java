//This will allow us to know if the hash cell had an entry or not
public class DeletedEntry extends HashEntry{
	//private static DeletedEntry delEntry = null;
	
		
	//For entries that are removed!
	public DeletedEntry(String k, String v){
		super(k, v);
	}
	
	public DeletedEntry(Available av, String k){
		super(av, k);
	}
	
	
	
	
	/*
	public static DeletedEntry getDeletedEntry(){
		if(delEntry == null)
			delEntry = new DeletedEntry();
		
		return delEntry;
	}
	*/

}
