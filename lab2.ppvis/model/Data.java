package lab2.model;

import java.util.ArrayList;
import java.util.List;

import lab2.controller.Adapter;

public class Data {

	private Adapter adapter;
	private LoaderSaver loaderSaver;
	private DOMPars domPars;
	private Student student;
	private SearchTableModel searchTableModel;
	PagingModel pagingModel;
	PagingModel searchPagingModel;
	
	public List<Student> studList;
	public List<Student> searchList;
	
	public Data(Adapter adapter) {
		super();
		this.adapter = adapter;
		loaderSaver = new LoaderSaver(this);
		domPars = new DOMPars(this);
		
		studList = new ArrayList<Student>();
		searchList = new ArrayList<Student>();
		/*for(int i = 0; i < 2; i++){
			studList.add(new Student("" + i, "w", "w", "w", "w", "w", "w", "w"));
		} */
		
		searchTableModel = new SearchTableModel(searchList);
		pagingModel = new PagingModel(studList);
		searchPagingModel = new PagingModel(searchList);
		
	}

	
	///////////////////////  Getters  ////////////////////
	public Adapter getAdapter() {
		return adapter;
	}
	
	public LoaderSaver getLoaderSaver() {
		return loaderSaver;
	}
	
	public DOMPars getDomPars() {
		return domPars;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public SearchTableModel getSearchTableModel() {
		return searchTableModel;
	}
	
	public PagingModel getPagingModel() {
		return pagingModel;
	}
	
	public PagingModel getSearchPagingModel() {
		return searchPagingModel;
	}
}
