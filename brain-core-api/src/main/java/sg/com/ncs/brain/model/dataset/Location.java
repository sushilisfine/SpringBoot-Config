package sg.com.ncs.brain.model.dataset;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.DefaultColumns;

//@Entity
@Data
@NoArgsConstructor
//@Table(name = "location")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean latitude;
	private Boolean longitude;

	@Embedded
	private DefaultColumns defaultColumns;
}