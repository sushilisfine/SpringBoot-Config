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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;

@Entity
@Data
@NoArgsConstructor
@Table(name = "general_tables_templates")
public class GeneralTablesTemplates implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String table_name;
	private String display_name;

	@Column(nullable = false)
	private Integer tableSeqNo;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean is_editable;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

	@OneToMany(mappedBy = "generalTablesTemplates")
	private List<GeneralFieldsTemplates> generalFieldsTemplates = new ArrayList<>();

}