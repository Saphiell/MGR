package magisterka.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import magisterka.db.methods.GetFromDB;


@Entity
@Table(name="folder")
public class Folder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "folder_name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="folder",
				cascade=CascadeType.ALL)
	private List<DataFile> data;
	
	@Transient
	private List<String> foldernames;
	
	@Transient
	public String folderName;
	
	
	public Folder(){}

	public Folder(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DataFile> getData() {
		return data;
	}

	public void setData(List<DataFile> data) {
		this.data = data;
	}

	
	public void addDataFile(DataFile theDataFile){
		if(data ==null){
			data = new ArrayList<>();
		}
		
		data.add(theDataFile);
		theDataFile.setFolder(this);
	}
	@Override
	public String toString() {
		return "Folder [id=" + id + ", name=" + name + "]";
	}
/*
	public List<String> getFoldernames() {
		GetData gd = new GetData();
		return gd.GetFolders().stream().filter(i->i!=null).map(i -> i.getName()).collect(Collectors.toList());
	}

	
	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
*/
	
}
