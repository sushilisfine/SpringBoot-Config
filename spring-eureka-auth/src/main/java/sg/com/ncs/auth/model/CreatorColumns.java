package sg.com.ncs.auth.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CreatorColumns implements Serializable {

	private static final long serialVersionUID = -9048388092593453654L;
	private String created_by;
	private String updated_by;

}
