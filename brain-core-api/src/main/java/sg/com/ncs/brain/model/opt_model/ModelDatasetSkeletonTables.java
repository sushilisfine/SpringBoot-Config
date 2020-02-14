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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;
import sg.com.ncs.brain.model.dataset.DatasetData;

@Entity
@Data
@NoArgsConstructor
@Table(name = "model_dataset_skeleton_tables", indexes = {
		@Index(name = "model_dataset_index", columnList = "table_name,model_id,status", unique = false) })
public class ModelDatasetSkeletonTables implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// @Column(nullable = false)
	// private Integer model_id;
	@Column(nullable = false)
	private String table_name;
	private String display_name;

	@Column(nullable = false)
	private Integer tableSeqNo;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean is_editable;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@ManyToOne
	private Model model;

	@OneToMany(mappedBy = "modelDatasetSkeletonTables")
	private List<ModelDatasetSkeletonFields> modelDatasetSkeletonFields = new ArrayList<>();

	@OneToMany(mappedBy = "modelDatasetSkeletonTables")
	private List<DatasetData> datasetData = new ArrayList<>();

}