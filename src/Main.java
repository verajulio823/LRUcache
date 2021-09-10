import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Movie;
import model.Response;


public class Main {
	
	static LRUCache<Response> cache;

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub

		cache = new LRUCache<Response>(3);
		String uriApi = "https://api.themoviedb.org/3/search/movie?api_key=13e9d05f4e53dc9f7e0e1165a8c2c45c&query=";
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Búsqueda de peliculas");
		System.out.println("1.- Para finalizar escriba \"Exit\"");
		System.out.println("2.- Para ver la última búsqueda escriba \"Historial\"");
		System.out.println("2.- Para ver la última búsqueda escriba \"TodoHistorial\"");
		System.out.println("Búsqueda de peliculas");
		System.out.println("Ingrese el nombre de la película: ");
		String stitle ="";
		
		while(!stitle.equals("exit") ) {
		    
			stitle = in.nextLine().toLowerCase();
			if(stitle.equals("exit"))
				break;
			if(stitle.equals("historial") || stitle.equals("todohistorial")) {
				if(stitle.equals("historial")){
					if (cache.get_most_recent_key().equals(""))
						System.out.println("Aún nada :P");
					else
						System.out.println("Última búsqueda: "+cache.get_most_recent_key());	
				}else {
					if(cache.get_all_keys()==null)
						System.out.println("Aún nada :P");
					else 
						System.out.println("Últimas búsquedas en cache:"+cache.get_all_keys());
					
				}
				
			}
			else {
				Response r=searchMovie(uriApi, stitle);
				if(r.getTotal_results()==0) 
					System.out.println("No se encontró la película");
				else
					for(Movie m : r.getResults()) {
						System.out.println(m);
					}
			}
			
			    		
		}
		System.out.println("Terminó búsqueda");
    
    
	}
	
	static Response searchMovie(String uriApi, String stitle) throws IOException, InterruptedException {
		if(cache.get_value_from_key(stitle)!=null) {
			System.out.println("Búsqueda en cache:");
			return  cache.get_value_from_key(stitle);
		}
		System.out.println("Búsqueda en odbm api:");
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(uriApi+stitle.replace(" ","+")))
	          .build();
	    HttpResponse<String> response = null;
		try {
			 response= client.send(request, BodyHandlers.ofString());
	
		}catch(Exception e) {
			System.out.println("Problemas de conexión");
		}
	   	    
	    Gson gson = new Gson();
	    Response r = gson.fromJson(response.body().toString(), Response.class);
	    cache.push(stitle, r);
	    return r;
	}
	
	

}
