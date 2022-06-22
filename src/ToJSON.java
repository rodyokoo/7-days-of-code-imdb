import org.json.JSONArray;
import org.json.JSONObject;

public class ToJSON {

	private JSONArray itemsArray;
	
	public ToJSON(APIConsumerTop250 api) {		
		this.itemsArray = new JSONObject(api.getResponse().body()).getJSONArray("items");
	}

	public JSONArray getItemsArray() {
		return itemsArray;
	}

}
