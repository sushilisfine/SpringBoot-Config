package sg.com.ncs.brain.model.opt_model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;
import sg.com.ncs.brain.model.dataset.Datasets;

@Entity
@Data
//@Audited
@NoArgsConstructor
@Table(name = "models", indexes = {
		@Index(name = "model_idx", columnList = "model_name,model_description_header,model_status", unique = false) })
public class Model implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String optimisationModelId;
	@Column(nullable = false, columnDefinition = "INTEGER DEFAULT 1")
	private Integer versionNum;
	private String model_name;
	private String model_description_header;
	private String model_description_details;
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean model_status;
	@Column(nullable = true)
	private Integer alg_id;

	@OneToMany(mappedBy = "model")
	// @NotAudited
	private List<ModelAccess> modelAccess = new ArrayList<>();

	// @NotAudited
	@OneToMany(mappedBy = "model")
	private List<Constraints> constraints = new ArrayList<>();

	// @NotAudited
	@OneToMany(mappedBy = "model")
	private List<Jobs> jobs = new ArrayList<>();

	// @NotAudited
	@OneToMany(mappedBy = "model")
	private List<ModelCustomFields> modelCustomFields = new ArrayList<>();

	// @NotAudited
	@OneToMany(mappedBy = "model")
	private List<Datasets> dataSets = new ArrayList<>();

	// @NotAudited
	@OneToMany(mappedBy = "model")
	private List<Algorithm> algorithm = new ArrayList<>();

	// @NotAudited
	@OneToMany(mappedBy = "model")
	private List<ModelDatasetSkeletonTables> modelDatasetSkeletonTables = new ArrayList<>();

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

}