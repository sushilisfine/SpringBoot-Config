package sg.com.ncs.brain.model.dataset;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;
import sg.com.ncs.brain.model.opt_model.ModelDatasetSkeletonFields;
import sg.com.ncs.brain.model.opt_model.ModelDatasetSkeletonTables;

@Entity
@Data
@NoArgsConstructor
//@Audited
@Table(name = "dataset_data", indexes = { @Index(name = "dataset_idx", columnList = "dataset_id", unique = false) })
public class DatasetData implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer dataset_id;
	private Integer dataset_skeleton_table_id;
	private Integer dataset_skeleton_field_id;
	private Integer record_id;
	private String value;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

	@ManyToOne
	private Datasets datasets;

	@ManyToOne
	private ModelDatasetSkeletonTables modelDatasetSkeletonTables;

	@ManyToOne
	private ModelDatasetSkeletonFields modelDatasetSkeletonFields;

}