package magisterka.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="folder")
public class Folder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "folder_name")
	private double name;
	
	@OneToMany(fetch = FetchType.LAZY,
			mappedBy="folder",
			cascade={CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH})
	private List<DataFile> data;
	
	public Folder(){}

	public Folder(double name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getName() {
		return name;
	}

	public void setName(double name) {
		this.name = name;
	}

	public List<DataFile> getData() {
		return data;
	}

	public void setData(List<DataFile> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Folder [id=" + id + ", name=" + name + ", data=" + data + "]";
	}
	
	
	
}
