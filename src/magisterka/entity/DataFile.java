package magisterka.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class DataFile {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cordx")
	private double cordx;
	
	@Column(name = "cordy")
	private double cordy;
	
	@Column(name = "value")
	private double depth;
	
	@ManyToOne(fetch= FetchType.LAZY,cascade={CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name = "folder_id")
	private Folder folder;
	
	public DataFile(){}

	public DataFile(double cordx, double cordy, double depth) {
		super();
		this.cordx = cordx;
		this.cordy = cordy;
		this.depth = depth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCordx() {
		return cordx;
	}

	public void setCordx(double cordx) {
		this.cordx = cordx;
	}

	public double getCordy() {
		return cordy;
	}

	public void setCordy(double cordy) {
		this.cordy = cordy;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	@Override
	public String toString() {
		return "DataFile [id=" + id + ", cordx=" + cordx + ", cordy=" + cordy + ", depth=" + depth + ", folder="
				+ folder + "]";
	}
	
	
	
}
