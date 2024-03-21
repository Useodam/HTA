package com.sample.post;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.user.User;

@Repository
public interface PostVoterRepository extends JpaRepository<PostVoter, Long>{

	Optional<PostVoter> findByPostAndUser(Post post, User user);
}
