package model;

public class Movie {
	String Title;
	String Year;
	String Released;
	String Genre;
	String Director;
	String Actors;
	String imdbID;
	String Type;
	Boolean Response;
	
	
	public Movie() {
		
	}
	
	
	public Movie(String title, String year, String released, String genre, String director, String actors,
			String imdbID, String type, Boolean response) {
		super();
		Title = title;
		Year = year;
		Released = released;
		Genre = genre;
		Director = director;
		Actors = actors;
		this.imdbID = imdbID;
		Type = type;
		Response = response;
	}
	
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getReleased() {
		return Released;
	}
	public void setReleased(String released) {
		Released = released;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Boolean getResponse() {
		return Response;
	}
	public void setResponse(Boolean response) {
		Response = response;
	}
	
	 @Override
	public String toString() {
	    return "Movie{" +
	                " Titulo: "+Title+","+
	                " Año: "+Year+","+
	                " Genero: "+Genre+","+
	                " Actores: "+Actors+","+
	                " Id: "+imdbID+
	                '}';
	}
	
}
