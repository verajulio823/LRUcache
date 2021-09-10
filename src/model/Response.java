package model;

import java.util.List;

public class Response {
	Integer page;
	List<Movie> results;
	Integer total_pages;
	Integer total_results;
	
	public Response() {
		
	}
	
	
	public Response(Integer page, List<Movie> results, Integer total_pages, Integer total_results) {
		super();
		this.page = page;
		this.results = results;
		this.total_pages = total_pages;
		this.total_results = total_results;
	}
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public List<Movie> getResults() {
		return results;
	}
	public void setResults(List<Movie> results) {
		this.results = results;
	}
	public Integer getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}
	public Integer getTotal_results() {
		return total_results;
	}
	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}

	
	
}
