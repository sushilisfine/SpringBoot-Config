package sg.com.ncs.auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sg.com.ncs.auth.user_maint.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByUsername(String userName);

}