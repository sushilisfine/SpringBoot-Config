package sg.com.ncs.brain.model.opt_model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;
import sg.com.ncs.brain.model.dataset.Datasets;

@Entity
@Data
@NoArgsConstructor
//@Audited
@Table(name = "jobs")
public class Jobs implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String jobId;
	// private Integer model_id;
	private Integer dataset_id;
	private String description;
	private LocalDate completed_datetime;
	private LocalDate submitted_datetime;
	private Boolean status;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@ManyToOne
	private Model model;

	@ManyToOne
	private Datasets datasets;

	@OneToMany(mappedBy = "jobs")
	private List<JobsSettings> jobSettings = new ArrayList<>();

	@OneToMany(mappedBy = "jobs")
	private List<JobsStatusUpdate> jobsStatusUpdate = new ArrayList<>();

	@OneToMany(mappedBy = "jobs")
	private List<OptimizedJobs> OptimizedJobs = new ArrayList<>();

}