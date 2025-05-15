
public class Task {
	import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
	 
	public class Task1 {
		public static String lambda_handler(String event,String context){
			String  json_load = event;
			boolean errorkey = false;
			Map<String,String> dict1= new HashMap<>();
			Map<String,String> response_dict= new HashMap<>();
			Map<String,String> enduser_response= new HashMap<>();
			String statusCode = " ";
			try {
				 if(!json_load.isEmpty()) {
					 if (json_load.get('queryStringParameters') !=null){
					        if (json_load.get('queryStringParameters').contains('Country') &&  ! json_load.get('queryStringParameters').contains("State")){
					        	String Country = (String)((Map<String,String>)json_load.get('queryStringParameters')).get('Country');
					        	PK1 = "Country#"+Country;
					        			//
					        	String State_info = (String) db_query.get('Items');	
					        	if(!State_info.isEmpty()) {
					        		for(String item : State_info) {
					        			String State_info = (String)item.get('States');
					        		}
					        		for(String state : State_info) {
					        			if(state.contains('code')	) {
					        				State_info.remove(state);
					        				}
					        		}
					        		//sorted_data.sort(Comparator.comparing(m ->(Comparable) m.get("name"));
				        			List<Map<String,String>>  sorted_data =State_info.stream().sort(Comparator.comparing(m ->(Comparable) m.get("name"))).collect(Collectors.toList());					        			//sorted_data.sort(Comparator.comparing(m ->(Comparable) m.get("name"));

					        		response_dict.put("Statelist", sorted_data);
					        		int statusCode = 201;
					        	}
					        	else {
					        		enduser_response.put("Error","No data in DB");
					        		int statusCode = 400;
					        		throw new Exception();
					        	}
					        	
					           }
					        else {
					        	System.out.println("checking for State data");
					        
					        }
					        if (json_load.get('queryStringParameters').contains('Country') && json_load.get('queryStringParameters').contains('Country')) {
					        	String Country = (String)((Map<String,String>)json_load.get('queryStringParameters')).get('Country');
					        	String State = (String)((Map<String,String>)json_load.get('queryStringParameters')).get('State');
					        	PK1 = "Country#"+Country;
			        			//
			        	        String City_info = (String) db_query.get('Items');	
					        	if(!City_info.isEmpty()) {
					        		Map<String,String> Citydict= new HashMap<>();
					        		for(String item : City_info) {
					        			if(item.get('State_Name') == State) {
						        			String City_list = (String)item.get('Cities_Name');
						        			//sorted_data.sort(Comparator.comparing(m ->(Comparable) m.get("name"));
						        			List<Map<String,String>>  sorted_data = City_list.stream().sort(Comparator.comparing(m ->(Comparable) m.get("name"))).collect(Collectors.toList());					        			//sorted_data.sort(Comparator.comparing(m ->(Comparable) m.get("name"));

							        		response_dict.put("Citylist", sorted_data);
							        		int statusCode = 201;
					        				
					        			}
					        		}
					        	}
					        	else {
					        		enduser_response.put("Error","No data in DB");
					        		int statusCode = 400;
					        		throw new Exception();
					        	}
					        }
					        }
					 else {
						 System.out.println("check for Country data");
					 }
				 }
			}
			catch (Exception e) {
				// TODO: handle exception
				errorkey = true;
			}
			finally {
        		Map<String,Map<String,String>> responseObject= new HashMap<>();
        		responseObject.put("headers", new HashMap<>());
        		responseObject.get("headers").put("Content-Type", "application_json");
        		if(errorkey) {
        			responseObject.put("statusCode", statusCode);
            		Map<String,Map<String,String>> headers= new HashMap<>();
            		headers.put("Access-Control-Allow-Headers": "X-Api-Key,Content-Type,X-Amz-Date,Accept");
            		

        			
        		}
        		
			}
		}

	 
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Task1 t=new Task1();
			String event;
			String context;
			t.lambda_handler(event,context);

	 
		}

	 
	}

}
