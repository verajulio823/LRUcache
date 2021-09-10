package model;

public class Movie {

	Integer id;
	String original_title;
	Double vote_average;
	Double vote_count;
	Double popularity;
	String overview;
	String release_date;
	
	public Movie() {
		
	}
	
	
	

	 public Movie(Integer id, String original_title, Double vote_average, Double vote_count, Double popularity,
			String overview, String release_date) {
		super();
		this.id = id;
		this.original_title = original_title;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.popularity = popularity;
		this.overview = overview;
		this.release_date = release_date;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getOriginal_title() {
		return original_title;
	}




	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}




	public Double getVote_average() {
		return vote_average;
	}




	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}




	public Double getVote_count() {
		return vote_count;
	}




	public void setVote_count(Double vote_count) {
		this.vote_count = vote_count;
	}




	public Double getPopularity() {
		return popularity;
	}




	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}




	public String getOverview() {
		return overview;
	}




	public void setOverview(String overview) {
		this.overview = overview;
	}




	public String getRelease_date() {
		return release_date;
	}




	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}




	@Override
	public String toString() {
	    return "Movie{" +
	    		    " Id: "+id+","+
	                " Titulo: "+original_title+","+
	                " Año: "+release_date+","+
	                " Votos: "+vote_average+","+
	                " Descripción: "+overview+","+
	               
	                '}';
	}
	
}
