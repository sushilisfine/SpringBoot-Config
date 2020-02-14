package sg.com.ncs.brain.model.dataset;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;
import sg.com.ncs.brain.model.opt_model.Jobs;
import sg.com.ncs.brain.model.opt_model.Model;

@Entity
@Data
@NoArgsConstructor
//@Audited
@Table(name = "datasets", indexes = {
		@Index(name = "dataset_idx1", columnList = "model_id,status,is_masterds", unique = false),
		@Index(name = "dataset_idx2", columnList = "datasetId,name,is_masterds,status", unique = false) })
public class Datasets implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String datasetId;
	private String name;
	private String description;
	// private Integer model_id;
	private LocalDate scheduleDateTime;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean is_masterds;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

	@ManyToOne
	private Model model;

	@OneToMany(mappedBy = "datasets")
	private List<Jobs> jobs = new ArrayList<>();

	@OneToMany(mappedBy = "datasets")
	private List<DatasetData> dataSetData = new ArrayList<>();

}