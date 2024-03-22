package com.sample.reply;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.user.User;

@Repository
public interface ReplyVoterRepository extends JpaRepository<ReplyVoter, Long>{

	Optional<ReplyVoter> findByReplyAndUser(Reply reply, User user);
}
